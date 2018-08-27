/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.wlw.zyx.baidu.utils;


import com.wlw.zyx.baidu.exception.FaceError;

public interface OnResultListener<T> {
    void onResult(T result);

    void onError(FaceError error);
}
