package com.ffzxnet.mdtest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        initToolBar("","",false,false);

        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.bg);
        //处理高斯图像
        BasePostprocessor basePostprocessor = new BasePostprocessor() {
            @Override
            public CloseableReference<Bitmap> process(Bitmap sourceBitmap, PlatformBitmapFactory bitmapFactory) {
                int w = sourceBitmap.getWidth();
                int h = sourceBitmap.getHeight();
                int xy, wh;
                if (w > h) {
                    xy = h / 4;
                    wh = h / 2;
                } else {
                    xy = w / 4;
                    wh = w / 2;
                }

                return super.process(StackBlur.blurNatively(bitmapFactory.createBitmap(sourceBitmap, xy, xy, wh, wh).get(), 20, false), bitmapFactory);
            }

        };


//        Uri uri = Uri.parse("res:///" + R.mipmap.ag);
        ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithResourceId(R.mipmap.ag)
                .setRotationOptions(RotationOptions.autoRotate())
                .setPostprocessor(basePostprocessor).build();
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(imageRequest)
                .setOldController(simpleDraweeView.getController()).build();
        simpleDraweeView.setController(draweeController);


        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setExpandedTitleColor(Color.WHITE);//字体显示颜色
        collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE);//toolbar字体显示颜色
        collapsingToolbar.setTitle("测试标题");//标题字


        ((LinearLayout) findViewById(R.id.card_lay)).getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转
                startActivity(new Intent(v.getContext(), Main2Activity.class));
            }
        });
    }


}
