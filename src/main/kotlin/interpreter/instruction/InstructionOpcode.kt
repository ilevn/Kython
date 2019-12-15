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

package green.sailor.kython.interpreter.instruction

/**
 * This file is automatically generatted by running gen_instructionsky.py.
 * Do not edit yourself!
 * This file was generated using cpython version 3.9.0 on 2019-12-11T14:28:40.006383
 */

enum class InstructionOpcode(
    val opcode: Int,
    val hasConst: Boolean,
    val hasFree: Boolean,
    val hasName: Boolean,
    val hasRelJump: Boolean,
    val hasAbsJump: Boolean,
    val hasLocal: Boolean,
    val hasCmp: Boolean
) {
    POP_TOP(1, false, false, false, false, false, false, false),
    ROT_TWO(2, false, false, false, false, false, false, false),
    ROT_THREE(3, false, false, false, false, false, false, false),
    DUP_TOP(4, false, false, false, false, false, false, false),
    DUP_TOP_TWO(5, false, false, false, false, false, false, false),
    ROT_FOUR(6, false, false, false, false, false, false, false),
    NOP(9, false, false, false, false, false, false, false),
    UNARY_POSITIVE(10, false, false, false, false, false, false, false),
    UNARY_NEGATIVE(11, false, false, false, false, false, false, false),
    UNARY_NOT(12, false, false, false, false, false, false, false),
    UNARY_INVERT(15, false, false, false, false, false, false, false),
    BINARY_MATRIX_MULTIPLY(16, false, false, false, false, false, false, false),
    INPLACE_MATRIX_MULTIPLY(17, false, false, false, false, false, false, false),
    BINARY_POWER(19, false, false, false, false, false, false, false),
    BINARY_MULTIPLY(20, false, false, false, false, false, false, false),
    BINARY_MODULO(22, false, false, false, false, false, false, false),
    BINARY_ADD(23, false, false, false, false, false, false, false),
    BINARY_SUBTRACT(24, false, false, false, false, false, false, false),
    BINARY_SUBSCR(25, false, false, false, false, false, false, false),
    BINARY_FLOOR_DIVIDE(26, false, false, false, false, false, false, false),
    BINARY_TRUE_DIVIDE(27, false, false, false, false, false, false, false),
    INPLACE_FLOOR_DIVIDE(28, false, false, false, false, false, false, false),
    INPLACE_TRUE_DIVIDE(29, false, false, false, false, false, false, false),
    RERAISE(48, false, false, false, false, false, false, false),
    WITH_EXCEPT_START(49, false, false, false, false, false, false, false),
    GET_AITER(50, false, false, false, false, false, false, false),
    GET_ANEXT(51, false, false, false, false, false, false, false),
    BEFORE_ASYNC_WITH(52, false, false, false, false, false, false, false),
    END_ASYNC_FOR(54, false, false, false, false, false, false, false),
    INPLACE_ADD(55, false, false, false, false, false, false, false),
    INPLACE_SUBTRACT(56, false, false, false, false, false, false, false),
    INPLACE_MULTIPLY(57, false, false, false, false, false, false, false),
    INPLACE_MODULO(59, false, false, false, false, false, false, false),
    STORE_SUBSCR(60, false, false, false, false, false, false, false),
    DELETE_SUBSCR(61, false, false, false, false, false, false, false),
    BINARY_LSHIFT(62, false, false, false, false, false, false, false),
    BINARY_RSHIFT(63, false, false, false, false, false, false, false),
    BINARY_AND(64, false, false, false, false, false, false, false),
    BINARY_XOR(65, false, false, false, false, false, false, false),
    BINARY_OR(66, false, false, false, false, false, false, false),
    INPLACE_POWER(67, false, false, false, false, false, false, false),
    GET_ITER(68, false, false, false, false, false, false, false),
    GET_YIELD_FROM_ITER(69, false, false, false, false, false, false, false),
    PRINT_EXPR(70, false, false, false, false, false, false, false),
    LOAD_BUILD_CLASS(71, false, false, false, false, false, false, false),
    YIELD_FROM(72, false, false, false, false, false, false, false),
    GET_AWAITABLE(73, false, false, false, false, false, false, false),
    LOAD_ASSERTION_ERROR(74, false, false, false, false, false, false, false),
    INPLACE_LSHIFT(75, false, false, false, false, false, false, false),
    INPLACE_RSHIFT(76, false, false, false, false, false, false, false),
    INPLACE_AND(77, false, false, false, false, false, false, false),
    INPLACE_XOR(78, false, false, false, false, false, false, false),
    INPLACE_OR(79, false, false, false, false, false, false, false),
    RETURN_VALUE(83, false, false, false, false, false, false, false),
    IMPORT_STAR(84, false, false, false, false, false, false, false),
    SETUP_ANNOTATIONS(85, false, false, false, false, false, false, false),
    YIELD_VALUE(86, false, false, false, false, false, false, false),
    POP_BLOCK(87, false, false, false, false, false, false, false),
    POP_EXCEPT(89, false, false, false, false, false, false, false),
    STORE_NAME(90, false, false, true, false, false, false, false),
    DELETE_NAME(91, false, false, true, false, false, false, false),
    UNPACK_SEQUENCE(92, false, false, false, false, false, false, false),
    FOR_ITER(93, false, false, false, true, false, false, false),
    UNPACK_EX(94, false, false, false, false, false, false, false),
    STORE_ATTR(95, false, false, true, false, false, false, false),
    DELETE_ATTR(96, false, false, true, false, false, false, false),
    STORE_GLOBAL(97, false, false, true, false, false, false, false),
    DELETE_GLOBAL(98, false, false, true, false, false, false, false),
    LOAD_CONST(100, true, false, false, false, false, false, false),
    LOAD_NAME(101, false, false, true, false, false, false, false),
    BUILD_TUPLE(102, false, false, false, false, false, false, false),
    BUILD_LIST(103, false, false, false, false, false, false, false),
    BUILD_SET(104, false, false, false, false, false, false, false),
    BUILD_MAP(105, false, false, false, false, false, false, false),
    LOAD_ATTR(106, false, false, true, false, false, false, false),
    COMPARE_OP(107, false, false, false, false, false, false, true),
    IMPORT_NAME(108, false, false, true, false, false, false, false),
    IMPORT_FROM(109, false, false, true, false, false, false, false),
    JUMP_FORWARD(110, false, false, false, true, false, false, false),
    JUMP_IF_FALSE_OR_POP(111, false, false, false, false, true, false, false),
    JUMP_IF_TRUE_OR_POP(112, false, false, false, false, true, false, false),
    JUMP_ABSOLUTE(113, false, false, false, false, true, false, false),
    POP_JUMP_IF_FALSE(114, false, false, false, false, true, false, false),
    POP_JUMP_IF_TRUE(115, false, false, false, false, true, false, false),
    LOAD_GLOBAL(116, false, false, true, false, false, false, false),
    SETUP_FINALLY(122, false, false, false, true, false, false, false),
    LOAD_FAST(124, false, false, false, false, false, true, false),
    STORE_FAST(125, false, false, false, false, false, true, false),
    DELETE_FAST(126, false, false, false, false, false, true, false),
    RAISE_VARARGS(130, false, false, false, false, false, false, false),
    CALL_FUNCTION(131, false, false, false, false, false, false, false),
    MAKE_FUNCTION(132, false, false, false, false, false, false, false),
    BUILD_SLICE(133, false, false, false, false, false, false, false),
    LOAD_CLOSURE(135, false, true, false, false, false, false, false),
    LOAD_DEREF(136, false, true, false, false, false, false, false),
    STORE_DEREF(137, false, true, false, false, false, false, false),
    DELETE_DEREF(138, false, true, false, false, false, false, false),
    CALL_FUNCTION_KW(141, false, false, false, false, false, false, false),
    CALL_FUNCTION_EX(142, false, false, false, false, false, false, false),
    SETUP_WITH(143, false, false, false, true, false, false, false),
    LIST_APPEND(145, false, false, false, false, false, false, false),
    SET_ADD(146, false, false, false, false, false, false, false),
    MAP_ADD(147, false, false, false, false, false, false, false),
    LOAD_CLASSDEREF(148, false, true, false, false, false, false, false),
    EXTENDED_ARG(144, false, false, false, false, false, false, false),
    BUILD_LIST_UNPACK(149, false, false, false, false, false, false, false),
    BUILD_MAP_UNPACK(150, false, false, false, false, false, false, false),
    BUILD_MAP_UNPACK_WITH_CALL(151, false, false, false, false, false, false, false),
    BUILD_TUPLE_UNPACK(152, false, false, false, false, false, false, false),
    BUILD_SET_UNPACK(153, false, false, false, false, false, false, false),
    SETUP_ASYNC_WITH(154, false, false, false, true, false, false, false),
    FORMAT_VALUE(155, false, false, false, false, false, false, false),
    BUILD_CONST_KEY_MAP(156, false, false, false, false, false, false, false),
    BUILD_STRING(157, false, false, false, false, false, false, false),
    BUILD_TUPLE_UNPACK_WITH_CALL(158, false, false, false, false, false, false, false),
    LOAD_METHOD(160, false, false, true, false, false, false, false),
    CALL_METHOD(161, false, false, false, false, false, false, false);

    companion object {
        /**
         * Gets an opcode by int.
         */
        fun get(opcode: Int): InstructionOpcode {
            return when (opcode) {
                1 -> POP_TOP
                2 -> ROT_TWO
                3 -> ROT_THREE
                4 -> DUP_TOP
                5 -> DUP_TOP_TWO
                6 -> ROT_FOUR
                9 -> NOP
                10 -> UNARY_POSITIVE
                11 -> UNARY_NEGATIVE
                12 -> UNARY_NOT
                15 -> UNARY_INVERT
                16 -> BINARY_MATRIX_MULTIPLY
                17 -> INPLACE_MATRIX_MULTIPLY
                19 -> BINARY_POWER
                20 -> BINARY_MULTIPLY
                22 -> BINARY_MODULO
                23 -> BINARY_ADD
                24 -> BINARY_SUBTRACT
                25 -> BINARY_SUBSCR
                26 -> BINARY_FLOOR_DIVIDE
                27 -> BINARY_TRUE_DIVIDE
                28 -> INPLACE_FLOOR_DIVIDE
                29 -> INPLACE_TRUE_DIVIDE
                48 -> RERAISE
                49 -> WITH_EXCEPT_START
                50 -> GET_AITER
                51 -> GET_ANEXT
                52 -> BEFORE_ASYNC_WITH
                54 -> END_ASYNC_FOR
                55 -> INPLACE_ADD
                56 -> INPLACE_SUBTRACT
                57 -> INPLACE_MULTIPLY
                59 -> INPLACE_MODULO
                60 -> STORE_SUBSCR
                61 -> DELETE_SUBSCR
                62 -> BINARY_LSHIFT
                63 -> BINARY_RSHIFT
                64 -> BINARY_AND
                65 -> BINARY_XOR
                66 -> BINARY_OR
                67 -> INPLACE_POWER
                68 -> GET_ITER
                69 -> GET_YIELD_FROM_ITER
                70 -> PRINT_EXPR
                71 -> LOAD_BUILD_CLASS
                72 -> YIELD_FROM
                73 -> GET_AWAITABLE
                74 -> LOAD_ASSERTION_ERROR
                75 -> INPLACE_LSHIFT
                76 -> INPLACE_RSHIFT
                77 -> INPLACE_AND
                78 -> INPLACE_XOR
                79 -> INPLACE_OR
                83 -> RETURN_VALUE
                84 -> IMPORT_STAR
                85 -> SETUP_ANNOTATIONS
                86 -> YIELD_VALUE
                87 -> POP_BLOCK
                89 -> POP_EXCEPT
                90 -> STORE_NAME
                91 -> DELETE_NAME
                92 -> UNPACK_SEQUENCE
                93 -> FOR_ITER
                94 -> UNPACK_EX
                95 -> STORE_ATTR
                96 -> DELETE_ATTR
                97 -> STORE_GLOBAL
                98 -> DELETE_GLOBAL
                100 -> LOAD_CONST
                101 -> LOAD_NAME
                102 -> BUILD_TUPLE
                103 -> BUILD_LIST
                104 -> BUILD_SET
                105 -> BUILD_MAP
                106 -> LOAD_ATTR
                107 -> COMPARE_OP
                108 -> IMPORT_NAME
                109 -> IMPORT_FROM
                110 -> JUMP_FORWARD
                111 -> JUMP_IF_FALSE_OR_POP
                112 -> JUMP_IF_TRUE_OR_POP
                113 -> JUMP_ABSOLUTE
                114 -> POP_JUMP_IF_FALSE
                115 -> POP_JUMP_IF_TRUE
                116 -> LOAD_GLOBAL
                122 -> SETUP_FINALLY
                124 -> LOAD_FAST
                125 -> STORE_FAST
                126 -> DELETE_FAST
                130 -> RAISE_VARARGS
                131 -> CALL_FUNCTION
                132 -> MAKE_FUNCTION
                133 -> BUILD_SLICE
                135 -> LOAD_CLOSURE
                136 -> LOAD_DEREF
                137 -> STORE_DEREF
                138 -> DELETE_DEREF
                141 -> CALL_FUNCTION_KW
                142 -> CALL_FUNCTION_EX
                143 -> SETUP_WITH
                145 -> LIST_APPEND
                146 -> SET_ADD
                147 -> MAP_ADD
                148 -> LOAD_CLASSDEREF
                144 -> EXTENDED_ARG
                149 -> BUILD_LIST_UNPACK
                150 -> BUILD_MAP_UNPACK
                151 -> BUILD_MAP_UNPACK_WITH_CALL
                152 -> BUILD_TUPLE_UNPACK
                153 -> BUILD_SET_UNPACK
                154 -> SETUP_ASYNC_WITH
                155 -> FORMAT_VALUE
                156 -> BUILD_CONST_KEY_MAP
                157 -> BUILD_STRING
                158 -> BUILD_TUPLE_UNPACK_WITH_CALL
                160 -> LOAD_METHOD
                161 -> CALL_METHOD
                else -> error("Unknown opcode $opcode")
            }
        }
    }
}
