package top.wenyl.customviewdragball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;


/**
 * 作者：Rain Wen
 * 日期：2016/6/21 16:18
 * 功能：
 * 版本：
 * 改进：
 */
public class DragBall extends View {


       int width = 0;
      int height= 0;
    float loc = 0;
    float starty;
    float stopy;
    private float lastLoc;

    public DragBall(Context context) {
        super(context);
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getWidth();
        height = getHeight();




//        canvas.drawRect(100,100,200,a,paint);
//
//
//        canvas.scale(1,s);
//
//        paint.setColor(Color.BLUE);
//
//    canvas.drawRect(0,0,100,100,paint);

        dateDraw(canvas);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                starty = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                stopy = event.getY();
               loc =lastLoc+ stopy-starty;//第二次的移动实在上一次的基础上，所以要加上上一次的位置
                invalidate();

                break;
            case MotionEvent.ACTION_UP:

                lastLoc = loc;
                break;
        }

        return true;
    }

    public void dateDraw(Canvas canvas)
    {
        canvas.translate(0,loc);
        //这里画图
        Paint paint  = new Paint();
        // 画笔颜色为红色
        paint.setColor(Color.RED);
        // 宽度5个像素

        paint.setStrokeWidth(5);


        canvas.drawCircle(width/2,height/2,50,paint);

    }

}
