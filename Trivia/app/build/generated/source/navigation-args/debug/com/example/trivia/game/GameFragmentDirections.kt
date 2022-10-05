package com.example.trivia.game

import android.os.Bundle
import androidx.navigation.NavDirections
import com.example.trivia.R
import kotlin.Int

public class GameFragmentDirections private constructor() {
  private data class ActionGameFragmentToGameOverFragment(
    public val totalQuestions: Int,
    public val correctAnswers: Int
  ) : NavDirections {
    public override val actionId: Int = R.id.action_gameFragment_to_gameOverFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("totalQuestions", this.totalQuestions)
        result.putInt("correctAnswers", this.correctAnswers)
        return result
      }
  }

  private data class ActionGameFragmentToGameWinFragment(
    public val totalQuestions: Int,
    public val correctAnswers: Int
  ) : NavDirections {
    public override val actionId: Int = R.id.action_gameFragment_to_gameWinFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putInt("totalQuestions", this.totalQuestions)
        result.putInt("correctAnswers", this.correctAnswers)
        return result
      }
  }

  public companion object {
    public fun actionGameFragmentToGameOverFragment(totalQuestions: Int, correctAnswers: Int):
        NavDirections = ActionGameFragmentToGameOverFragment(totalQuestions, correctAnswers)

    public fun actionGameFragmentToGameWinFragment(totalQuestions: Int, correctAnswers: Int):
        NavDirections = ActionGameFragmentToGameWinFragment(totalQuestions, correctAnswers)
  }
}
