package com.home.vestlibs;

import android.util.Log;

import com.lzy.okgo.callback.Callback;
import com.lzy.okgo.convert.FileConvert;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

import java.io.File;

public abstract class FileCallBack implements Callback<File> {
    public FileCallBack() {
        this(null, null);
    }

    public FileCallBack(String filePath, String fileName) {
        convert = new FileConvert(filePath, fileName);
        convert.setCallback(this);
    }

    private FileConvert convert;    //文件转换类

    @Override
    public void onStart(Request<File, ? extends Request> request) {

    }

    @Override
    public void onSuccess(Response<File> response) {
        Log.e("onCacheSuccess", response.message());
    }

    @Override
    public void onCacheSuccess(Response<File> response) {
    }

    @Override
    public void onError(Response<File> response) {
        onError(response.message());
    }

    @Override
    public void onFinish() {

    }

    @Override
    public void uploadProgress(Progress progress) {
    }

    @Override
    public void downloadProgress(Progress progress) {
        onProgress((int) (progress.fraction * 100));
        if (progress.fraction >= 1) {
            onSuccess(new File(progress.filePath));
        }
    }

    @Override
    public File convertResponse(okhttp3.Response response) throws Throwable {
        File file = convert.convertResponse(response);
        response.close();
        return file;
    }

    abstract void onProgress(int progress);

    abstract void onSuccess(File file);

    abstract void onError(String msg);
}
