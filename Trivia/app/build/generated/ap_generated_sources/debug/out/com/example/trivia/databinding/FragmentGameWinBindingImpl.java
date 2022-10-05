package com.example.trivia.databinding;
import com.example.trivia.R;
import com.example.trivia.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentGameWinBindingImpl extends FragmentGameWinBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.imageView, 2);
        sViewsWithIds.put(R.id.question_tv, 3);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentGameWinBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private FragmentGameWinBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageView) bindings[2]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[1]
            );
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.scoreTv.setTag(null);
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
        if (BR.gameWinViewModel == variableId) {
            setGameWinViewModel((com.example.trivia.gameWin.GameWinViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setGameWinViewModel(@Nullable com.example.trivia.gameWin.GameWinViewModel GameWinViewModel) {
        this.mGameWinViewModel = GameWinViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.gameWinViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeGameWinViewModelScore((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeGameWinViewModelScore(androidx.lifecycle.MutableLiveData<java.lang.String> GameWinViewModelScore, int fieldId) {
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
        java.lang.String gameWinViewModelScoreGetValue = null;
        com.example.trivia.gameWin.GameWinViewModel gameWinViewModel = mGameWinViewModel;
        androidx.lifecycle.MutableLiveData<java.lang.String> gameWinViewModelScore = null;

        if ((dirtyFlags & 0x7L) != 0) {



                if (gameWinViewModel != null) {
                    // read gameWinViewModel.score
                    gameWinViewModelScore = gameWinViewModel.getScore();
                }
                updateLiveDataRegistration(0, gameWinViewModelScore);


                if (gameWinViewModelScore != null) {
                    // read gameWinViewModel.score.getValue()
                    gameWinViewModelScoreGetValue = gameWinViewModelScore.getValue();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x7L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.scoreTv, gameWinViewModelScoreGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): gameWinViewModel.score
        flag 1 (0x2L): gameWinViewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}