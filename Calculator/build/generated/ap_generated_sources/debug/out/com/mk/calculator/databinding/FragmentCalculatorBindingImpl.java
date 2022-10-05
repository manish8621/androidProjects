package com.mk.calculator.databinding;
import com.mk.calculator.R;
import com.mk.calculator.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentCalculatorBindingImpl extends FragmentCalculatorBinding implements com.mk.calculator.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.num1btn, 5);
        sViewsWithIds.put(R.id.num2btn, 6);
        sViewsWithIds.put(R.id.num8btn, 7);
        sViewsWithIds.put(R.id.num0btn, 8);
        sViewsWithIds.put(R.id.num5btn, 9);
        sViewsWithIds.put(R.id.num3btn, 10);
        sViewsWithIds.put(R.id.num9btn, 11);
        sViewsWithIds.put(R.id.num6btn, 12);
        sViewsWithIds.put(R.id.num4btn, 13);
        sViewsWithIds.put(R.id.num7btn, 14);
        sViewsWithIds.put(R.id.mod_btn, 15);
        sViewsWithIds.put(R.id.plus_btn, 16);
        sViewsWithIds.put(R.id.minus_btn, 17);
        sViewsWithIds.put(R.id.multiply_btn, 18);
        sViewsWithIds.put(R.id.parenthesis_close_btn, 19);
        sViewsWithIds.put(R.id.parenthesis_open_btn, 20);
        sViewsWithIds.put(R.id.dot_btn, 21);
        sViewsWithIds.put(R.id.div_btn, 22);
        sViewsWithIds.put(R.id.equals_btn, 23);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentCalculatorBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }
    private FragmentCalculatorBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.Button) bindings[1]
            , (android.widget.TextView) bindings[4]
            , (android.widget.Button) bindings[2]
            , (android.widget.Button) bindings[22]
            , (android.widget.Button) bindings[21]
            , (android.widget.Button) bindings[23]
            , (android.widget.Button) bindings[17]
            , (android.widget.Button) bindings[15]
            , (android.widget.Button) bindings[18]
            , (android.widget.Button) bindings[8]
            , (android.widget.Button) bindings[5]
            , (android.widget.Button) bindings[6]
            , (android.widget.Button) bindings[10]
            , (android.widget.Button) bindings[13]
            , (android.widget.Button) bindings[9]
            , (android.widget.Button) bindings[12]
            , (android.widget.Button) bindings[14]
            , (android.widget.Button) bindings[7]
            , (android.widget.Button) bindings[11]
            , (android.widget.Button) bindings[19]
            , (android.widget.Button) bindings[20]
            , (android.widget.Button) bindings[16]
            , (android.widget.TextView) bindings[3]
            );
        this.clearBtn.setTag(null);
        this.currentExpressTv.setTag(null);
        this.delBtn.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.prevExpressionTv.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new com.mk.calculator.generated.callback.OnClickListener(this, 2);
        mCallback1 = new com.mk.calculator.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.viewModel == variableId) {
            setViewModel((com.mk.calculator.CalculatorViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setViewModel(@Nullable com.mk.calculator.CalculatorViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelPrevExpression((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelExpression((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelPrevExpression(androidx.lifecycle.LiveData<java.lang.String> ViewModelPrevExpression, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelExpression(androidx.lifecycle.LiveData<java.lang.String> ViewModelExpression, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        androidx.lifecycle.LiveData<java.lang.String> viewModelPrevExpression = null;
        androidx.lifecycle.LiveData<java.lang.String> viewModelExpression = null;
        java.lang.String viewModelPrevExpressionGetValue = null;
        java.lang.String viewModelExpressionGetValue = null;
        com.mk.calculator.CalculatorViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.prevExpression
                        viewModelPrevExpression = viewModel.getPrevExpression();
                    }
                    updateLiveDataRegistration(0, viewModelPrevExpression);


                    if (viewModelPrevExpression != null) {
                        // read viewModel.prevExpression.getValue()
                        viewModelPrevExpressionGetValue = viewModelPrevExpression.getValue();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.expression
                        viewModelExpression = viewModel.getExpression();
                    }
                    updateLiveDataRegistration(1, viewModelExpression);


                    if (viewModelExpression != null) {
                        // read viewModel.expression.getValue()
                        viewModelExpressionGetValue = viewModelExpression.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.clearBtn.setOnClickListener(mCallback1);
            this.delBtn.setOnClickListener(mCallback2);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.currentExpressTv, viewModelExpressionGetValue);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.prevExpressionTv, viewModelPrevExpressionGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // viewModel
                com.mk.calculator.CalculatorViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.deleteExpression();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // viewModel
                com.mk.calculator.CalculatorViewModel viewModel = mViewModel;
                // viewModel != null
                boolean viewModelJavaLangObjectNull = false;



                viewModelJavaLangObjectNull = (viewModel) != (null);
                if (viewModelJavaLangObjectNull) {


                    viewModel.clearAllExpressions();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.prevExpression
        flag 1 (0x2L): viewModel.expression
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}