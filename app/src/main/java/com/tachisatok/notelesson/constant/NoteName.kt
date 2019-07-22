package com.tachisatok.notelesson.constant

/**
 * 音名を表すEnum
 *
 * @property characters よみがな
 */
enum class NoteName(
    val characters: Characters
) {
    /** ド */
    C(Characters.C),
    /** レ */
    D(Characters.D),
    /** ミ */
    E(Characters.E),
    /** ファ */
    F(Characters.F),
    /** ソ */
    G(Characters.G),
    /** ラ */
    A(Characters.A),
    /** シ */
    B(Characters.B)
}