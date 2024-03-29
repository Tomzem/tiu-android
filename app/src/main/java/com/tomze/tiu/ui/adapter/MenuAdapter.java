package com.tomze.tiu.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.tomze.tiu.R;
import com.tomze.tiu.base.BaseRecycler;
import com.tomze.tiu.bean.Menu;

import java.util.List;

/**
 * @author Tomze
 * @time 2019年04月06日 18:22
 * @desc 个人菜单界面Adapter
 */
public class MenuAdapter extends BaseRecycler.Adapter<Menu> {

    public MenuAdapter(List<Menu> mDataSource, Context mContext, int resID) {
        super(mDataSource, mContext, resID);
    }

    @Override
    protected void initView(BaseRecycler.ViewHolder holder, int position) {
        Menu menu = mDataSource.get(position);
        boolean isShow = !(menu.menuId == 0);

        holder.getContentView().setBackgroundColor(mContext.getResources().getColor(isShow ? R.color.colorWhite : R.color.colorTransparent));
        holder.isShow(R.id.v_line, isShow);

        ImageView mImgIcon = holder.getView(R.id.img_menu_icon);
        mImgIcon.setImageResource(menu.menuDrawable < 0 ? 0 : menu.menuDrawable);
        holder.isShow(mImgIcon, isShow);

        TextView mTvName = holder.getView(R.id.tv_menu_name);
        mTvName.setText(TextUtils.isEmpty(menu.menuName) ? "" : menu.menuName);
        holder.isShow(mTvName, isShow);

        TextView mTvRight = holder.getView(R.id.tv_menu_right);
        mTvRight.setText(TextUtils.isEmpty(menu.menuRight) ? "" : menu.menuRight);
        holder.isShow(mTvRight, isShow);

        ImageView mImgMore = holder.getView(R.id.img_menu_more);
        mImgMore.setImageResource(menu.menuRightPic < 0 ? 0 : menu.menuRightPic);
        holder.isShow(mImgMore, isShow);
    }
}
