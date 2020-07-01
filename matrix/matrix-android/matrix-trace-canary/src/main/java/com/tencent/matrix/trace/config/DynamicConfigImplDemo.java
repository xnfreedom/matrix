package com.tencent.matrix.trace.config;

import com.tencent.matrix.util.MatrixLog;
import com.tencent.mrs.plugin.IDynamicConfig;

public class DynamicConfigImplDemo implements IDynamicConfig {
    public enum MatrixEnum {

        /*****matrix begin********/
        // trace
        clicfg_matrix_trace_fps_enable,
        clicfg_matrix_trace_care_scene_set,
        clicfg_matrix_trace_fps_time_slice,
        clicfg_matrix_trace_load_activity_threshold,
        clicfg_matrix_trace_evil_method_threshold,

        clicfg_matrix_trace_fps_report_threshold,
        clicfg_matrix_trace_max_evil_method_stack_num,
        clicfg_matrix_trace_max_evil_method_try_trim_num,
        clicfg_matrix_trace_min_evil_method_druration,
        clicfg_matrix_trace_time_upload_duration,

        clicfg_matrix_fps_dropped_normal,
        clicfg_matrix_fps_dropped_middle,
        clicfg_matrix_fps_dropped_high,
        clicfg_matrix_fps_dropped_frozen,
        clicfg_matrix_trace_evil_method_enable,
        clicfg_matrix_trace_startup_enable,

        clicfg_matrix_trace_app_start_up_threshold,
        clicfg_matrix_trace_fps_frame_fresh_threshold,
        clicfg_matrix_trace_min_evil_method_run_cnt,
        clicfg_matrix_trace_min_evil_method_dur_time,

        clicfg_matrix_trace_splash_activity_name,

        //io
        clicfg_matrix_io_file_io_main_thread_enable,
        clicfg_matrix_io_main_thread_enable_threshold,
        clicfg_matrix_io_small_buffer_enable,
        clicfg_matrix_io_small_buffer_threshold,
        clicfg_matrix_io_small_buffer_operator_times,
        clicfg_matrix_io_repeated_read_enable,
        clicfg_matrix_io_repeated_read_threshold,
        clicfg_matrix_io_closeable_leak_enable,

        //resource
        clicfg_matrix_resource_detect_interval_millis,
        clicfg_matrix_resource_max_detect_times,
        clicfg_matrix_resource_dump_hprof_enable,


        /******matrix end*******/
    }

    private static final String TAG = "Matrix.DynamicConfigImplDemo";

    public DynamicConfigImplDemo() {

    }

    public boolean isFPSEnable() {
        return true;
    }

    public boolean isTraceEnable() {
        return true;
    }

    public boolean isMatrixEnable() {
        return true;
    }

    @Override
    public String get(String key, String defStr) {
        //TODO here return default value which is inside sdk, you can change it as you wish. matrix-sdk-key in class MatrixEnum.
        return defStr;
    }


    @Override
    public int get(String key, int defInt) {
        //TODO here return default value which is inside sdk, you can change it as you wish. matrix-sdk-key in class MatrixEnum.

        if (MatrixEnum.clicfg_matrix_resource_max_detect_times.name().equals(key)) {
            MatrixLog.i(TAG, "key:" + key + ", before change:" + defInt + ", after change, value:" + 2);
            return 2;//new value
        }

        if (MatrixEnum.clicfg_matrix_trace_fps_report_threshold.name().equals(key)) {
            return 10000;
        }

        if (MatrixEnum.clicfg_matrix_trace_fps_time_slice.name().equals(key)) {
            return 500;
        }

        return defInt;

    }

    @Override
    public long get(String key, long defLong) {
        //TODO here return default value which is inside sdk, you can change it as you wish. matrix-sdk-key in class MatrixEnum.
        if (MatrixEnum.clicfg_matrix_trace_fps_report_threshold.name().equals(key)) {
            return 10000L;
        }

        if (MatrixEnum.clicfg_matrix_resource_detect_interval_millis.name().equals(key)) {
            MatrixLog.i(TAG, key + ", before change:" + defLong + ", after change, value:" + 2000);
            return 2000;
        }

        return defLong;
    }


    @Override
    public boolean get(String key, boolean defBool) {
        //TODO here return default value which is inside sdk, you can change it as you wish. matrix-sdk-key in class MatrixEnum.

        return defBool;
    }

    @Override
    public float get(String key, float defFloat) {
        //TODO here return default value which is inside sdk, you can change it as you wish. matrix-sdk-key in class MatrixEnum.

        return defFloat;
    }

}
