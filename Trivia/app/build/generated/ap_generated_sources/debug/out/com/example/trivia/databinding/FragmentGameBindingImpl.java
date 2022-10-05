package com.example.trivia.databinding;
import com.example.trivia.R;
import com.example.trivia.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentGameBindingImpl extends FragmentGameBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView, 6);
        sViewsWithIds.put(R.id.choices_group, 7);
        sViewsWithIds.put(R.id.submit_btn, 8);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentGameBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private FragmentGameBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.RadioGroup) bindings[7]
            , (android.widget.ImageView) bindings[6]
            , (android.widget.TextView) bindings[1]
            , (android.widget.RadioButton) bindings[2]
            , (android.widget.RadioButton) bindings[3]
            , (android.widget.RadioButton) bindings[4]
            , (android.widget.RadioButton) bindings[5]
            , (android.widget.Button) bindings[8]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.questionTv.setTag(null);
        this.radioButton1.setTag(null);
        this.radioButton2.setTag(null);
        this.radioButton3.setTag(null);
        this.radioButton4.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.gameViewModel == variableId) {
            setGameViewModel((com.example.trivia.game.GameViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setGameViewModel(@Nullable com.example.trivia.game.GameViewModel GameViewModel) {
        this.mGameViewModel = GameViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.gameViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeGameViewModelCurrentQuestionAndAnswer((androidx.lifecycle.LiveData<com.example.trivia.game.QuestionAndAnswer>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeGameViewModelCurrentQuestionAndAnswer(androidx.lifecycle.LiveData<com.example.trivia.game.QuestionAndAnswer> GameViewModelCurrentQuestionAndAnswer, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String gameViewModelCurrentQuestionAndAnswerQuestionToString = null;
        java.lang.String gameViewModelCurrentQuestionAndAnswerQuestion = null;
        com.example.trivia.game.QuestionAndAnswer gameViewModelCurrentQuestionAndAnswerGetValue = null;
        java.lang.String gameViewModelCurrentQuestionAndAnswerChoices0 = null;
        com.example.trivia.game.GameViewModel gameViewModel = mGameViewModel;
        java.lang.String gameViewModelCurrentQuestionAndAnswerChoices1 = null;
        java.lang.String gameViewModelCurrentQuestionAndAnswerChoices2 = null;
        java.lang.String gameViewModelCurrentQuestionAndAnswerChoices3 = null;
        androidx.lifecycle.LiveData<com.example.trivia.game.QuestionAndAnswer> gameViewModelCurrentQuestionAndAnswer = null;
        java.lang.String[] gameViewModelCurrentQuestionAndAnswerChoices = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (gameViewModel != null) {
                    // read gameViewModel.currentQuestionAndAnswer
                    gameViewModelCurrentQuestionAndAnswer = gameViewModel.getCurrentQuestionAndAnswer();
                }
                updateLiveDataRegistration(0, gameViewModelCurrentQuestionAndAnswer);


                if (gameViewModelCurrentQuestionAndAnswer != null) {
                    // read gameViewModel.currentQuestionAndAnswer.getValue()
                    gameViewModelCurrentQuestionAndAnswerGetValue = gameViewModelCurrentQuestionAndAnswer.getValue();
                }


                if (gameViewModelCurrentQuestionAndAnswerGetValue != null) {
                    // read gameViewModel.currentQuestionAndAnswer.getValue().question
                    gameViewModelCurrentQuestionAndAnswerQuestion = gameViewModelCurrentQuestionAndAnswerGetValue.getQuestion();
                    // read gameViewModel.currentQuestionAndAnswer.getValue().choices
                    gameViewModelCurrentQuestionAndAnswerChoices = gameViewModelCurrentQuestionAndAnswerGetValue.getChoices();
                }


                if (gameViewModelCurrentQuestionAndAnswerQuestion != null) {
                    // read gameViewModel.currentQuestionAndAnswer.getValue().question.toString()
                    gameViewModelCurrentQuestionAndAnswerQuestionToString = gameViewModelCurrentQuestionAndAnswerQuestion.toString();
                }
                if (gameViewModelCurrentQuestionAndAnswerChoices != null) {
                    // read gameViewModel.currentQuestionAndAnswer.getValue().choices[0]
                    gameViewModelCurrentQuestionAndAnswerChoices0 = getFromArray(gameViewModelCurrentQuestionAndAnswerChoices, 0);
                    // read gameViewModel.currentQuestionAndAnswer.getValue().choices[1]
                    gameViewModelCurrentQuestionAndAnswerChoices1 = getFromArray(gameViewModelCurrentQuestionAndAnswerChoices, 1);
                    // read gameViewModel.currentQuestionAndAnswer.getValue().choices[2]
                    gameViewModelCurrentQuestionAndAnswerChoices2 = getFromArray(gameViewModelCurrentQuestionAndAnswerChoices, 2);
                    // read gameViewModel.currentQuestionAndAnswer.getValue().choices[3]
                    gameViewModelCurrentQuestionAndAnswerChoices3 = getFromArray(gameViewModelCurrentQuestionAndAnswerChoices, 3);
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.questionTv, gameViewModelCurrentQuestionAndAnswerQuestionToString);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.radioButton1, gameViewModelCurrentQuestionAndAnswerChoices0);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.radioButton2, gameViewModelCurrentQuestionAndAnswerChoices1);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.radioButton3, gameViewModelCurrentQuestionAndAnswerChoices2);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.radioButton4, gameViewModelCurrentQuestionAndAnswerChoices3);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): gameViewModel.currentQuestionAndAnswer
        flag 1 (0x2L): gameViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}