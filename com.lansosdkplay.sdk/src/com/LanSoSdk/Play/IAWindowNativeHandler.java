/*****************************************************************************
 * public class IAWindowNativeHandler.java
 *****************************************************************************/
/**
 * 
 * 杭州蓝松科技有限公司.LanSoSdk团队, 专业做多媒体音视频的方案公司.包括视频采集,编辑,编码, 传输,解码,处理,播放等.
 * 
 *  
 * 我们的部分视频高级播放功能如下: 欢迎商务合作
 * 1,设置视频下载缓冲器大小,设置视频缓冲时长.
 * 2,视频截屏,单帧播放.
 * 3,视频播放速度可调,任意速度可调.
 * 4,软硬解自动切换.完全支持软硬解.并软解功能支持NEON指令,多线程解码.
 * 5,视频录制.
 * 6,网络视频支持边播放、边下载功能. 支持快速全速下载.----网络不太好,或使用3G/4G情况下也可以流畅播放.
 * 7,网络视频,查看当前缓冲百分比, 查看当前网速.----
 * 8,支持对比度, 饱和度,色调,颜色提取,镜像,动态监测,分屏等12种功能,并可定制滤镜效果.  ----类似秒拍,美拍,快手的功能.
 * 9,支持左右3D, 红蓝3D播放.
 * 10,RTSP做视频直播时的延迟问题(定制).
 * 11,RTSP播放时马赛克严重的问题(定制).
 * 12,硬件在部分手机上不支持的问题(定制).
 * 13,M3U8网络播放时crash的问题(定制).
 * 14,playlist时自由拖动的问题(定制).
 * 15,解决您项目中遇到的各种视频网络等问题(定制).
 * 
 * Email:support@lansongtech.com.
 * @link https://github.com/LanSoSdk
 */
package com.LanSoSdk.Play;

import android.view.Surface;

public interface IAWindowNativeHandler {
    /**
     * Callback called from {@link IPlayVout#sendMouseEvent}.
     *
     * @param nativeHandle handle passed by {@link #setCallback}.
     * @param action see ACTION_* in {@link android.view.MotionEvent}.
     * @param button see BUTTON_* in {@link android.view.MotionEvent}.
     * @param x x coordinate.
     * @param y y coordinate.
     */
    void nativeOnMouseEvent(long nativeHandle, int action, int button, int x, int y);

    /**
     * Callback called from {@link IPlayVout#setWindowSize}.
     *
     * @param nativeHandle handle passed by {@link #setCallback}.
     * @param width width of the window.
     * @param height height of the window.
     */
    void nativeOnWindowSize(long nativeHandle, int width, int height);

    /**
     * Get the valid Video surface.
     *
     * @return can be null if the surface was destroyed.
     */
    @SuppressWarnings("unused") /* Used by JNI */
    Surface getVideoSurface();

    @SuppressWarnings("unused") /* Used by JNI  */
    Surface getVideoSurface2();
    
    /**
     * Get the valid Subtitles surface.
     *
     * @return can be null if the surface was destroyed.
     */
    @SuppressWarnings("unused") /* Used by JNI */
    Surface getSubtitlesSurface();

    /**
     * Set a callback in order to receive {@link #nativeOnMouseEvent} and {@link #nativeOnWindowSize} events.
     *
     * @param nativeHandle native Handle passed by {@link #nativeOnMouseEvent} and {@link #nativeOnWindowSize}
     * @return true if callback was successfully registered
     */
    @SuppressWarnings("unused") /* Used by JNI */
    boolean setCallback(long nativeHandle);

    /**
     * This method is only used for ICS and before since ANativeWindow_setBuffersGeometry doesn't work before.
     * It is synchronous.
     *
     * @param surface surface returned by getVideoSurface or getSubtitlesSurface
     * @param width surface width
     * @param height surface height
     * @param format color format (or PixelFormat)
     * @return true if buffersGeometry were set (only before ICS)
     */
    @SuppressWarnings("unused") /* Used by JNI */
    boolean setBuffersGeometry(Surface surface, int width, int height, int format);

    /**
     * Set the window Layout.
     * This call will result of {@link IPlayVout.Callback#onNewLayout} being called from the main thread.
     *
     * @param width Frame width
     * @param height Frame height
     * @param visibleWidth Visible frame width
     * @param visibleHeight Visible frame height
     * @param sarNum Surface aspect ratio numerator
     * @param sarDen Surface aspect ratio denominator
     */
    @SuppressWarnings("unused") /* Used by JNI */
    void setWindowLayout(int width, int height, int visibleWidth, int visibleHeight, int sarNum, int sarDen);
}