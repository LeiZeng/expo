/**
 * Copyright (c) 2015-present, Horcrux.
 * All rights reserved.
 *
 * This source code is licensed under the MIT-style license found in the
 * LICENSE file in the root directory of this source tree.
 */


package versioned.host.exp.exponent.modules.api.components.svg;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import com.facebook.common.logging.FLog;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Shadow node for virtual Use view
 */
public class UseShadowNode extends RenderableShadowNode {

    private String mHref;
    private String mWidth;
    private String mHeight;

    @ReactProp(name = "href")
    public void setHref(String href) {
        mHref = href;
        markUpdated();
    }

    @ReactProp(name = "width")
    public void setWidth(String width) {
        mWidth = width;
        markUpdated();
    }

    @ReactProp(name = "height")
    public void setHeight(String height) {
        mHeight = height;
        markUpdated();
    }

    public String getWidth() {
        return mWidth;
    }

    public String getHeight() {
        return mHeight;
    }

    @Override
    public void draw(Canvas canvas, Paint paint, float opacity) {
        VirtualNode template = getSvgShadowNode().getDefinedTemplate(mHref);

        if (template != null) {
            if (template instanceof RenderableShadowNode) {
                ((RenderableShadowNode)template).mergeProperties(this);
            }

            int count = template.saveAndSetupCanvas(canvas);
            clip(canvas, paint);

            if (template instanceof SymbolShadowNode) {
                SymbolShadowNode symbol = (SymbolShadowNode)template;
                symbol.drawSymbol(canvas, paint, opacity, relativeOnWidth(mWidth), relativeOnHeight(mHeight));
            } else {
                template.draw(canvas, paint, opacity * mOpacity);
            }

            template.restoreCanvas(canvas, count);
            if (template instanceof RenderableShadowNode) {
                ((RenderableShadowNode)template).resetProperties();
            }
        } else {
            FLog.w(ReactConstants.TAG, "`Use` element expected a pre-defined svg template as `href` prop, " +
                "template named: " + mHref + " is not defined.");
        }
    }

    @Override
    protected Path getPath(Canvas canvas, Paint paint) {
        // todo:
        return new Path();
    }
}
