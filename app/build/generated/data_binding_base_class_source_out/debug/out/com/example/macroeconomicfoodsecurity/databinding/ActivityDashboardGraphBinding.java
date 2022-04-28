// Generated by view binder compiler. Do not edit!
package com.example.macroeconomicfoodsecurity.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.macroeconomicfoodsecurity.R;
import com.github.mikephil.charting.charts.LineChart;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDashboardGraphBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button annotateButton;

  @NonNull
  public final Button button5;

  @NonNull
  public final EditText editTextNumber;

  @NonNull
  public final EditText editTextNumberDecimal;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final LineChart linechart;

  @NonNull
  public final Spinner spinner3;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  private ActivityDashboardGraphBinding(@NonNull LinearLayout rootView,
      @NonNull Button annotateButton, @NonNull Button button5, @NonNull EditText editTextNumber,
      @NonNull EditText editTextNumberDecimal, @NonNull ImageView imageView,
      @NonNull LineChart linechart, @NonNull Spinner spinner3, @NonNull TextView textView3,
      @NonNull TextView textView4, @NonNull TextView textView5) {
    this.rootView = rootView;
    this.annotateButton = annotateButton;
    this.button5 = button5;
    this.editTextNumber = editTextNumber;
    this.editTextNumberDecimal = editTextNumberDecimal;
    this.imageView = imageView;
    this.linechart = linechart;
    this.spinner3 = spinner3;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.textView5 = textView5;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDashboardGraphBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDashboardGraphBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_dashboard_graph, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDashboardGraphBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.annotateButton;
      Button annotateButton = ViewBindings.findChildViewById(rootView, id);
      if (annotateButton == null) {
        break missingId;
      }

      id = R.id.button5;
      Button button5 = ViewBindings.findChildViewById(rootView, id);
      if (button5 == null) {
        break missingId;
      }

      id = R.id.editTextNumber;
      EditText editTextNumber = ViewBindings.findChildViewById(rootView, id);
      if (editTextNumber == null) {
        break missingId;
      }

      id = R.id.editTextNumberDecimal;
      EditText editTextNumberDecimal = ViewBindings.findChildViewById(rootView, id);
      if (editTextNumberDecimal == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.linechart;
      LineChart linechart = ViewBindings.findChildViewById(rootView, id);
      if (linechart == null) {
        break missingId;
      }

      id = R.id.spinner3;
      Spinner spinner3 = ViewBindings.findChildViewById(rootView, id);
      if (spinner3 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      return new ActivityDashboardGraphBinding((LinearLayout) rootView, annotateButton, button5,
          editTextNumber, editTextNumberDecimal, imageView, linechart, spinner3, textView3,
          textView4, textView5);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
