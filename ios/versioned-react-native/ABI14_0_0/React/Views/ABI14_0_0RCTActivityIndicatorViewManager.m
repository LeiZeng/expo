/**
 * Copyright (c) 2015-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

#import "ABI14_0_0RCTActivityIndicatorViewManager.h"

#import "ABI14_0_0RCTActivityIndicatorView.h"
#import "ABI14_0_0RCTConvert.h"

@implementation ABI14_0_0RCTConvert (UIActivityIndicatorView)

// NOTE: It's pointless to support UIActivityIndicatorViewStyleGray
// as we can set the color to any arbitrary value that we want to

ABI14_0_0RCT_ENUM_CONVERTER(UIActivityIndicatorViewStyle, (@{
  @"large": @(UIActivityIndicatorViewStyleWhiteLarge),
  @"small": @(UIActivityIndicatorViewStyleWhite),
}), UIActivityIndicatorViewStyleWhiteLarge, integerValue)

@end

@implementation ABI14_0_0RCTActivityIndicatorViewManager

ABI14_0_0RCT_EXPORT_MODULE()

- (UIView *)view
{
  return [ABI14_0_0RCTActivityIndicatorView new];
}

ABI14_0_0RCT_EXPORT_VIEW_PROPERTY(color, UIColor)
ABI14_0_0RCT_EXPORT_VIEW_PROPERTY(hidesWhenStopped, BOOL)
ABI14_0_0RCT_REMAP_VIEW_PROPERTY(size, activityIndicatorViewStyle, UIActivityIndicatorViewStyle)
ABI14_0_0RCT_CUSTOM_VIEW_PROPERTY(animating, BOOL, UIActivityIndicatorView)
{
  BOOL animating = json ? [ABI14_0_0RCTConvert BOOL:json] : [defaultView isAnimating];
  if (animating != [view isAnimating]) {
    if (animating) {
      [view startAnimating];
    } else {
      [view stopAnimating];
    }
  }
}

@end
