package com.como.RNTShadowView;

import android.graphics.Color;
import androidx.annotation.Nullable;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RNTShadowViewManager extends ViewGroupManager<ShadowView> {
    public static final String REACT_CLASS = "RNTShadowView";

    @ReactProp(name = "borderRadius", defaultDouble = 0)
    public void setBorderRadius(final ShadowView shadowView, @Nullable double borderRadius) {
        if (shadowView != null) {
            shadowView.setBorderRadius(borderRadius);
        }
    }

    @ReactProp(name = "borderColor")
    public void setBorderColor(final ShadowView shadowView, @Nullable String borderColor) {
        if (shadowView != null) {
            shadowView.setBorderColor(parseColor(borderColor));
        }
    }

    @ReactProp(name = "borderWidth")
    public void setBorderWidth(final ShadowView shadowView, @Nullable double borderWidth) {
        if (shadowView != null) {
            shadowView.setBorderWidth(borderWidth);
        }
    }

    @ReactProp(name = "backgroundColor")
    public void setBackgroundColor(final ShadowView shadowView, @Nullable String backgroundColor) {
        if (shadowView != null) {
            shadowView.setBackgroundColor(parseColor(backgroundColor));
        }
    }

    @ReactProp(name = "shadowColor")
    public void setShadowColor(final ShadowView shadowView, @Nullable String shadowColor) {
        if (shadowView != null) {
            shadowView.setShadowColor(parseColor(shadowColor));
        }
    }

    @ReactProp(name = "shadowOffsetX", defaultDouble = 0)
    public void setShadowOffsetX(final ShadowView shadowView, @Nullable double shadowOffsetX) {
        if (shadowView != null) {
            shadowView.setShadowOffsetX(shadowOffsetX);
        }
    }

    @ReactProp(name = "shadowOffsetY", defaultDouble = 0)
    public void setShadowOffsetY(final ShadowView shadowView, @Nullable double shadowOffsetY) {
        if (shadowView != null) {
            shadowView.setShadowOffsetY(shadowOffsetY);
        }
    }

    @ReactProp(name = "shadowOpacity", defaultDouble = 1)
    public void setShadowOpacity(final ShadowView shadowView, @Nullable double shadowOpacity) {
        if (shadowView != null) {
            shadowView.setShadowOpacity(shadowOpacity);
        }
    }

    @ReactProp(name = "shadowRadius")
    public void setShadowRadius(final ShadowView shadowView, double shadowRadius) {
        if (shadowView != null) {
            shadowView.setShadowRadius(shadowRadius);
        }
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public ShadowView createViewInstance(ThemedReactContext context) {
        return new ShadowView(context);
    }

    private int parseColor(String colorString) {
        if (colorString == null) {
            return Color.TRANSPARENT;
        }
        Pattern pattern = Pattern.compile("\\((\\d+),(\\d+),(\\d+)(,([\\d|\\.]+)|.*?)");

        Matcher m = pattern.matcher(colorString);
        if (m.find()) {
            int red = Integer.parseInt(m.group(1));
            int green = Integer.parseInt(m.group(2));
            int blue = Integer.parseInt(m.group(3));
            int alpha = 255;
            if (m.groupCount() == 5) {
                Pattern alphaPattern = Pattern.compile("[\\d|\\.]+");
                Matcher alphaMatch = alphaPattern.matcher(m.group(4));
                if (alphaMatch.find()) {
                    alpha = (int)(Double.parseDouble(alphaMatch.group(0)) * 255);
                }
            }
            return Color.argb(alpha, red, green, blue);
        } else {
            try {
                return Color.parseColor(colorString);
            }
            catch(Exception ex) {
                return Color.BLACK;
            }
        }
    }
}
