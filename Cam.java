package com.gen_5_new.Fragment;
import android.Manifest;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import com.gen_5_new.MainActivity;
import com.gen_5_new.OnFragmentInteractionListener;
import com.gen_5_new.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class Cam extends Fragment implements SurfaceHolder.Callback, View.OnClickListener,
        Camera.AutoFocusCallback, Camera.PreviewCallback, Camera.PictureCallback, OnFragmentInteractionListener {
    //
    //implements CameraIo
    public Camera camera;
    public SurfaceView preview;
    public Button shotBtn;
    public final String TAG_CAM = "LifeCam";
    private OnFragmentInteractionListener mListener;


    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getActivity()).setContentView(R.layout.fragment_camera);

        //permission
        if(ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(new MainActivity(), new String[]{Manifest.permission.CAMERA}, 15); }

        // если хотим, чтобы приложение постоянно имело портретную ориентацию
        Objects.requireNonNull(getActivity()).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // если хотим, чтобы приложение было полноэкранным
        Objects.requireNonNull(getActivity()).getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // и без заголовка
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // наше SurfaceView имеет имя SurfaceView01
        preview = Objects.requireNonNull(getActivity()).findViewById(R.id.SurfaceView01);

        SurfaceHolder surfaceHolder = preview.getHolder();
        surfaceHolder.addCallback(this);
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        // кнопка имеет имя Button01
        shotBtn = Objects.requireNonNull(getActivity()).findViewById(R.id.Button01);
        shotBtn.setText("Shot");
        shotBtn.setOnClickListener(this::onClick);
    }
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_camera, container, false);
    }
    @Override public void onFragmentInteraction(Uri uri) { }
    @Override public void onResume() { super.onResume(); camera = Camera.open(); }
    @Override public void onPause() { super.onPause();
        if (camera != null) {
            camera.setPreviewCallback(null);
            camera.stopPreview();
            camera.release();
            camera = null;
        }
    }
    @Override public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) { }
    @Override public void surfaceCreated(SurfaceHolder holder) {
        try { camera.setPreviewDisplay(holder); camera.setPreviewCallback(this); }
        catch (IOException e) { e.printStackTrace(); }

        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        float aspect = (float) previewSize.width / previewSize.height;

        int previewSurfaceWidth = preview.getWidth();
        int previewSurfaceHeight = preview.getHeight();

        ViewGroup.LayoutParams lp = preview.getLayoutParams();

        // здесь корректируем размер отображаемого preview, чтобы не было искажений

        if (this.getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
            // портретный вид
            camera.setDisplayOrientation(90);
            lp.height = previewSurfaceHeight;
            lp.width = (int) (previewSurfaceHeight / aspect);
        } else {
            // ландшафтный
            camera.setDisplayOrientation(0);
            lp.width = previewSurfaceWidth;
            lp.height = (int) (previewSurfaceWidth / aspect);
        }

        preview.setLayoutParams(lp);
        camera.startPreview();
    }
    @Override public void surfaceDestroyed(SurfaceHolder holder) { }
    @Override public void onClick(View v) {
        if (v == shotBtn) {
            // либо делаем снимок непосредственно здесь
            // либо включаем обработчик автофокуса

            //camera.takePicture(null, null, null, this);
//            camera.autoFocus(this);

            Objects.requireNonNull(getActivity()).setContentView(R.layout.fragment_solving_chem_equ);
        }
    }
    @Override public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera) {
        // сохраняем полученные jpg в папке /sdcard/CameraExample/
        // имя файла - System.currentTimeMillis()

        try { File saveDir = new File("/sdcard/CameraExample/");

            if (!saveDir.exists()) { saveDir.mkdirs(); }

            FileOutputStream os = new FileOutputStream(String.format("/sdcard/CameraExample/%d.jpg", System.currentTimeMillis()));
            os.write(paramArrayOfByte);
            os.close();
        } catch (Exception e) { }

        // после того, как снимок сделан, показ превью отключается. необходимо включить его
        paramCamera.startPreview();
    }
    @Override public void onAutoFocus(boolean paramBoolean, Camera paramCamera) {
        if (paramBoolean) {
            // если удалось сфокусироваться, делаем снимок
            paramCamera.takePicture(null, null, null, this);
        }
    }
    @Override public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera) {
        // здесь можно обрабатывать изображение, показываемое в preview
    }
}