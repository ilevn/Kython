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

package green.sailor.kython.interpreter.objects.python.primitives

import arrow.core.Either
import green.sailor.kython.interpreter.objects.python.PyException
import green.sailor.kython.interpreter.objects.python.PyObject
import green.sailor.kython.interpreter.objects.python.PyType

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
        override fun newInstance(args: Map<String, PyObject>): Either<PyException, PyObject> {
            // another simple passthrough
            return Either.right(fromAnyMap(args))
        }
    }

    override fun toPyString(): Either<PyException, PyString> {
        val builder = StringBuilder()
        builder.append('{')
        for ((k, v) in this.items) {
            val maybeKey = k.toPyStringRepr()
            if (maybeKey.isLeft()) return maybeKey
            maybeKey.map { builder.append(it.wrappedString) }

            builder.append(": ")

            val maybeValue = v.toPyStringRepr()
            if (maybeValue.isLeft()) return maybeValue
            maybeValue.map { builder.append(it.wrappedString) }
            builder.append(", ")
        }
        builder.append('}')
        return Either.right(PyString(builder.toString()))
    }

    override fun toPyStringRepr(): Either<PyException, PyString> = toPyString()

    /**
     * Gets an item from the internal dict.
     */
    fun getItem(key: PyObject): PyObject? {
        return this.items[key]
    }

}
