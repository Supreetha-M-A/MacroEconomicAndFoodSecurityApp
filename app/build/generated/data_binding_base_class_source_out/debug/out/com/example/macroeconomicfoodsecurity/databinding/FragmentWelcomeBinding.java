// Generated by view binder compiler. Do not edit!
package com.example.macroeconomicfoodsecurity.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.macroeconomicfoodsecurity.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentWelcomeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RadioGroup accountRadioGroup;

  @NonNull
  public final RadioButton govtOfficial;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final RadioButton researcher;

  @NonNull
  public final Spinner spinner1;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView3;

  private FragmentWelcomeBinding(@NonNull ConstraintLayout rootView,
      @NonNull RadioGroup accountRadioGroup, @NonNull RadioButton govtOfficial,
      @NonNull ImageView imageView, @NonNull ImageView imageView3, @NonNull ImageView imageView4,
      @NonNull RadioButton researcher, @NonNull Spinner spinner1, @NonNull TextView textView,
      @NonNull TextView textView3) {
    this.rootView = rootView;
    this.accountRadioGroup = accountRadioGroup;
    this.govtOfficial = govtOfficial;
    this.imageView = imageView;
    this.imageView3 = imageView3;
    this.imageView4 = imageView4;
    this.researcher = researcher;
    this.spinner1 = spinner1;
    this.textView = textView;
    this.textView3 = textView3;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentWelcomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentWelcomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_welcome, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentWelcomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.accountRadioGroup;
      RadioGroup accountRadioGroup = ViewBindings.findChildViewById(rootView, id);
      if (accountRadioGroup == null) {
        break missingId;
      }

      id = R.id.govtOfficial;
      RadioButton govtOfficial = ViewBindings.findChildViewById(rootView, id);
      if (govtOfficial == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.researcher;
      RadioButton researcher = ViewBindings.findChildViewById(rootView, id);
      if (researcher == null) {
        break missingId;
      }

      id = R.id.spinner1;
      Spinner spinner1 = ViewBindings.findChildViewById(rootView, id);
      if (spinner1 == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      return new FragmentWelcomeBinding((ConstraintLayout) rootView, accountRadioGroup,
          govtOfficial, imageView, imageView3, imageView4, researcher, spinner1, textView,
          textView3);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
