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
package green.sailor.kython.interpreter.functions

import green.sailor.kython.interpreter.KythonInterpreter
import green.sailor.kython.interpreter.iface.ArgType
import green.sailor.kython.interpreter.iface.PyCallableSignature
import green.sailor.kython.interpreter.pyobject.PyDict
import green.sailor.kython.interpreter.pyobject.PyObject
import green.sailor.kython.interpreter.pyobject.PyString
import green.sailor.kython.interpreter.pyobject.PyTuple
import green.sailor.kython.interpreter.pyobject.types.PyRootType
import green.sailor.kython.interpreter.stack.UserCodeStackFrame

/**
 * Represents the `__build_class__` builtin, used to create new classes.
 */
object BuildClassFunction : PyBuiltinFunction("__build_class__") {
    override fun callFunction(kwargs: Map<String, PyObject>): PyObject {
        val clsFn = kwargs["class_body"]!!.cast<PyUserFunction>()
        val name = kwargs["name"]!!.cast<PyString>()
        val bases = kwargs["bases"]!!.cast<PyTuple>()

        // TODO: __prepare__
        // build the class body dict
        val items = linkedMapOf<PyObject, PyObject>()
        val bodyDict = PyDict(items)
        if (clsFn.code.argCount > 0) {
            clsFn.pyCall(listOf(bodyDict))
        } else {
            // if you pass a builtin to `__build_class__`, you deserve this error
            val frame = clsFn.createFrame() as UserCodeStackFrame
            val args = clsFn.signature.getFinalArgs(listOf())
            KythonInterpreter.runStackFrame(frame, args)
            items.putAll(frame.locals.mapKeys { PyString(it.key) })
        }

        // figure out the metaclass
        val kws = kwargs["keywords"]!!.cast<PyDict>().internalDict
        val metaclass = kws.getOrDefault("metaclass", PyRootType)
        // type(name, bases, class_dict)
        return metaclass.pyCall(listOf(bodyDict, bases, name))
    }

    override val signature: PyCallableSignature = PyCallableSignature(
        "class_body" to ArgType.POSITIONAL,
        "name" to ArgType.POSITIONAL,
        "bases" to ArgType.POSITIONAL_STAR,
        "keywords" to ArgType.KEYWORD_STAR
    )
}