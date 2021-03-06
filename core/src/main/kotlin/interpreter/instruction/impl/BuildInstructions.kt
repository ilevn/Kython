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
 */

@file:JvmName("InstructionImpls")
@file:JvmMultifileClass
package green.sailor.kython.interpreter.instruction.impl

import green.sailor.kython.interpreter.cast
import green.sailor.kython.interpreter.pyobject.*
import green.sailor.kython.interpreter.stack.UserCodeStackFrame
import green.sailor.kython.util.PyObjectMap

/**
 * BUILD_CONST_KEY_MAP
 */
fun UserCodeStackFrame.buildConstKeyMap(arg: Byte) {
    val argCount = arg.toInt()
    val tuple = stack.pop().cast<PyTuple>()
    val args = (0 until argCount).map { stack.pop() }.asReversed().iterator()
    val collected =
        tuple.subobjects.associateWithTo(PyObjectMap()) { args.next() }
    stack.push(PyDict.from(collected))
    bytecodePointer += 1
}

/**
 * BUILD_* (TUPLE, LIST, SET, etc). Does not work for CONST_KEY_MAP!
 */
fun UserCodeStackFrame.buildSimple(type: BuildType, arg: Byte) {
    val count = arg.toInt()
    val built = when (type) {
        BuildType.TUPLE -> {
            PyTuple.get((0 until count).map { stack.pop() }.reversed())
        }
        BuildType.LIST -> {
            PyList((0 until count).map { stack.pop() }.reversed().toMutableList())
        }
        BuildType.STRING -> {
            val concatString = (0 until count)
                .map { (stack.pop() as PyString).wrappedString }
                .reversed()
                .joinToString(separator = "")
            PyString(concatString)
        }
        BuildType.SET -> {
            PySet(
                LinkedHashSet((0 until count)
                    .map { stack.pop() }
                    .reversed())
            )
        }
        else -> TODO("Unimplemented build type $type")
    }
    stack.push(built)
    bytecodePointer += 1
}

/**
 * LIST_APPEND
 */
fun UserCodeStackFrame.listAppend(param: Byte) {
    // the stack isn't a stack!
    // !!!!
    val toAdd = stack.pop()
    val list = stack[stack.size - param.toInt()]
    if (list !is PyList) error("Cannot LIST_APPEND on non-list $list")
    if (list.subobjects !is MutableList) error("List is immutable?")
    list.subobjects.add(toAdd)

    bytecodePointer += 1
}
