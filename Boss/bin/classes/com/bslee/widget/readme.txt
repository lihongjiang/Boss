查看了FragmentTabHost的源码，可以知道FragmentTabHost不保存状态是因为切
换fragment的时候是使用detach和attach来Fragment的隐藏和显示的，这样的话
每次切换肯定要重新加载布局，处理使用detach和attach，我们还可以使用show
和hide来实现显示和隐藏，这样可以保存状态，方案出来了就是修改
FragmentTabHost源码将切换Fragment的方式detach和attach改为hide和show。

FragmentTabHost的一个bug,布局不能放下面,解决方法.修改源码.
 private void initFragmentTabHost(Context context, AttributeSet attrs) 

{
        TypedArray a = context.obtainStyledAttributes(attrs,
                new int[] { android.R.attr.inflatedId }, 0, 0);
        mContainerId = a.getResourceId(0, 0);
        a.recycle();

        super.setOnTabChangedListener(this);

        // If owner hasn't made its own view hierarchy, then as a 

convenience
        // we will construct a standard one here.


/***** HERE COMMENT CODE BECAUSE findViewById(android.R.id.tabs) EVERY 

TIME IS NULL WE HAVE OWN LAYOUT ******//


//        if (findViewById(android.R.id.tabs) == null) {
//            LinearLayout ll = new LinearLayout(context);
//            ll.setOrientation(LinearLayout.VERTICAL);
//            addView(ll, new FrameLayout.LayoutParams(
//                    ViewGroup.LayoutParams.FILL_PARENT,
//                    ViewGroup.LayoutParams.FILL_PARENT));
//
//            TabWidget tw = new TabWidget(context);
//            tw.setId(android.R.id.tabs);
//            tw.setOrientation(TabWidget.HORIZONTAL);
//            ll.addView(tw, new LinearLayout.LayoutParams(
//                    ViewGroup.LayoutParams.FILL_PARENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT, 0));
//
//            FrameLayout fl = new FrameLayout(context);
//            fl.setId(android.R.id.tabcontent);
//            ll.addView(fl, new LinearLayout.LayoutParams(0, 0, 0));
//
//            mRealTabContent = fl = new FrameLayout(context);
//            mRealTabContent.setId(mContainerId);
//            ll.addView(fl, new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.FILL_PARENT, 0, 1));
//        }
    }