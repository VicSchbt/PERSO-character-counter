package com.example.charactercounter.counting.domain

data class TextAnalysisResult(
    val characterCount: Int,
    val wordCount: Int,
    val sentenceCount: Int,
    val estimatedTimeReading: String? = null
) {
    companion object {
        fun from(text: String, isBlankSpaceExcluded: Boolean): TextAnalysisResult {
            val characterCount = if (isBlankSpaceExcluded) text.trim().split("\\s+".toRegex())
                .joinToString("").length else text.length

            val wordCount = text
                .trim() // Removes leading/trailing spaces
                .split("\\s+".toRegex()) // Splits by 1 or more whitespace (space, tab, etc.)
                .filter { it.isNotBlank() } // Excludes empty strings (in case of double spaces)
                .size

            val sentenceCount = text
                .trim() // Removes leading/trailing spaces
                .split(Regex("[.!?]+")) // Splits on . or ! or ?, including sequences like "...???"
                .map { it.trim() } // Cleans each piece
                .filter { it.isNotEmpty() } // 	Ignores extra separators or trailing punctuation
                .size

            val estimatedTimeReading = estimateReadingTime(wordCount)

            return TextAnalysisResult(
                characterCount = characterCount,
                wordCount = wordCount,
                sentenceCount = sentenceCount,
                estimatedTimeReading = estimatedTimeReading
            )
        }

        private fun estimateReadingTime(wordCount: Int, wpm: Int = 200): String? {
            if (wordCount == 0) return null

            val minutes = wordCount / wpm
            val seconds = ((wordCount % wpm) * 60) / wpm

            return when {
                minutes == 0 -> "< 1 min"
                seconds in 1..30 -> "$minutes min"
                else -> "${minutes + 1} min"
            }
        }
    }
}