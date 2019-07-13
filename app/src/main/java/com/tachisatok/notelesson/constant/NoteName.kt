package com.tachisatok.notelesson.constant

/**
 * 音名を表すEnum
 *
 * @property character よみがな
 */
enum class NoteName(
    val character: Character
) {
    /** ド */
    C(Character.C),
    /** レ */
    D(Character.D),
    /** ミ */
    E(Character.E),
    /** ファ */
    F(Character.F),
    /** ソ */
    G(Character.G),
    /** ラ */
    A(Character.A),
    /** シ */
    B(Character.B)
}