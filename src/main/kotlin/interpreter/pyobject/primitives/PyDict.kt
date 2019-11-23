/*
 * This file is part of kython.
 *
 * kython is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * kython is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with kython.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package green.sailor.kython.interpreter.pyobject.primitives

import green.sailor.kython.interpreter.pyobject.PyObject
import green.sailor.kython.interpreter.pyobject.PyType

/**
 * Represents a Python dict, a mapping between PyObject -> PyObject.
 */
class PyDict(val items: LinkedHashMap<out PyObject, out PyObject>) : PyObject(PyDictType) {
    companion object {
        /** Represents the empty dict. */
        val EMPTY = PyDict(linkedMapOf())

        /**
         * Creates a new PyDict from any map, wrapping primitive types.
         */
        fun fromAnyMap(map: Map<*, *>): PyDict {
            val newMap = map.map {
                val key = if (it.key !is PyObject) {
                    wrapPrimitive(it.key)
                } else {
                    it.key as PyObject
                }

                val value = if (it.value !is PyObject) {
                    wrapPrimitive(it.value)
                } else {
                    (it.value as PyObject)
                }

                Pair(key, value)
            }.toMap().toMutableMap()
            return PyDict(newMap as LinkedHashMap<out PyObject, out PyObject>)
        }
    }

    object PyDictType : PyType("dict") {
        override fun newInstance(args: Map<String, PyObject>): PyObject {
            // another simple passthrough
            return fromAnyMap(args)
        }
    }

    override fun toPyString(): PyString = PyString("{" + this.items.entries.joinToString(", ") {
                it.key.toPyStringRepr().wrappedString + ": " + it.value.toPyStringRepr().wrappedString
            } + "}")

    override fun toPyStringRepr(): PyString = toPyString()

    /**
     * Gets an item from the internal dict.
     */
    fun getItem(key: PyObject): PyObject? {
        return this.items[key]
    }

}