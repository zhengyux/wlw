/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.wlw.zyx.baidu.parser;

import com.wlw.zyx.baidu.exception.FaceError;

/**
 * JSON解析
 * @param <T>
 */
public interface Parser<T> {
    T parse(String json) throws FaceError;
}
