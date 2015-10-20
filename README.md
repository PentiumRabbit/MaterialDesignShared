# MaterialDesignShared
材料设计分享，学习

[TOC]

## 说明
该项目用于材料设计学习，分享

## 库介绍

### support design




#### AppBarLayout

- AppBarLayout 是继承自一个垂直的 LinearLayout

#### TabLayout

- 背景色会自动设置成 primary color(主题色)
- app:tabMode
	* fixed
	* scrollable

- app:tabGravity
	* fill
	* center

#### FloatingActionButton

- app:fabSize="normal"是用来定义 FAB 的大小的（推荐 40dp 的清晰的 png 文件）
    * normal的意思是在大多数情况下标准尺寸为 56dp 的按钮
    * mini是另一个选择，它的大小将变成 40dp

- 按钮的颜色，FAB 基本上使用强调色，重写app:backgroundTint属性来修改
- app:elevation为空闲状态下的阴影深度(6dp 在空闲状态)
- andapp:pressedTranslationZ为按下状态的(12dp 是按下状态)
- app:backgroundTint - 设置FAB的背景颜色。
- app:rippleColor - 设置FAB点击时的背景颜色。
- app:borderWidth - 该属性尤为重要，如果不设置0dp，那么在4.1的sdk上FAB会显示为正方形，而且在5.0以后的sdk没有阴影效果。所以设置为borderWidth="0dp"。
- app:elevation - 默认状态下FAB的阴影大小。
- app:pressedTranslationZ - 点击时候FAB的阴影大小。
- app:fabSize - 设置FAB的大小，该属性有两个值，分别为normal和mini，对应的FAB大小分别为56dp和40dp。
- src - 设置FAB的图标，Google建议符合Design设计的该图标大小为24dp。
- app:layout_anchor - 设置FAB的锚点，即以哪个控件为参照点设置位置。
- app:layout_anchorGravity - 设置FAB相对锚点的位置，值有 bottom、center、right、left、top等。

#### NavigationView
#### Snackbar

- Snackbar 和 Toast 有着相同的概念，但是不同于 Toast，它的表现是作为 UI 的一部分而不是覆盖在屏幕上。

	![Snackbar](./Doc/Image/md_snackbar.jpg)

    ```java
    Snackbar.make(someView, "Hello. I am Snackbar!", Snackbar.LENGTH_SHORT)
    .setAction("Undo", new View.OnClickListener() {
          @Override
          public void onClick(View v) {
           }
         }).show();

    ```

- 低于 Android L 的系统上，当 Snackbar 滑动消失的时候，FAB 忘记了移动下来。只需要为低于 Android L 的系统改变 margin 的值为 0.1dp(不好用)

#### SwipeRefreshLayout
#### TextInputLayout

- code

    ```xml
        <android.support.design.widget.TextInputLayout
            android:id="@+id/til_name"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

            <EditText
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:hint="用户名"/>
        </android.support.design.widget.TextInputLayout>
    ```


#### AppCompatSpinner
#### SwitchCompat
#### CollapsingToolbarLayout

- 让 Toolbar 折叠起来
- Toolbar中不需要 layout_scrollFlags
	`app:layout_collapseMode="pin"`
    `app:layout_collapseParallaxMultiplier="0.7"` == 设置偏移 ==

    - parallax, 表示滚动过程中,会一直保持可见区域在正中间,配合layout_collapseParallaxMultiplier
    - pin, 表示不会被滚出屏幕范围
    - app:layout_collapseParallaxMultiplier和CollapsingToolbarLayout的app:contentScrim=”?attr/colorPrimary”结合使用，结果就是在视图折叠时，添加了一个纱布效果

#### CoordinatorLayout

- LinearLayout 没有被设计成与 CoordinatorLayout 协同工作,只需在相应的中添加:
	`app:layout_behavior="@string/appbar_scrolling_view_behavior"`
- Toolbar 添加一个滚动标志,想要 TabLayout 同样从屏幕上消失
	`app:layout_scrollFlags="scroll|enterAlways"`
    * scroll- 你想你想要设置这个 view 随着内容滚动，你需要应用这个标志。
    * enterAlwaysCollapsed- 这个标志定义了 View 是如何回到屏幕的。当你的 view 已经声明了一个最小高度(minHeight) 并且你使用了这个标志，** 你的 View 只有在回到这个最小的高度的时候 **才会展开，只有当 view 已经到达顶部之后它才会重新展开全部高度。
    * enterAlways- 这个标志确保了** 任何向下滚动的操作 **都会让这个 view 变得可见，达到“快速返回”(‘quick return’ )的效果，滚动标志像这样来使用它：scroll|enterAlways
    * exitUntilCollapsed- View 将关闭滚动直到它被折叠起来(有 minHeight) 并且一直保持这样

- ScrollView 没有被设计成与 CoordinatorLayout 协同工作,NestedScrollView，Android Support Library v4,替代
- ListView 类也是和 CoordinatorLayout 不能协同工作的。只有RecyclerView可以

###V7 support appcompat
- RecyclerView
	* RecyclerView.LayoutManager
        1. StaggeredGridLayoutManager
        2. LinearLayoutManager
            + GridLayoutManager
- Toolbar

###V7 cardview library
- CardView

### 参看

> http://www.open-open.com/lib/view/open1436152483833.html

