package com.example.prabaths.TravelBuddy;

import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.Espresso.openContextualActionModeOverflowMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeRight;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static android.support.test.InstrumentationRegistry.*;

import android.support.test.espresso.matcher.BoundedMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.runner.RunWith;
import org.junit.Rule;
import org.junit.Test;

import android.view.View;
import android.view.ViewGroup;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testGenerated() {
        
	// Click at LinearLayout with child index 1 of parent with id android.R.id.tabs
onView(nthChildOf(withId(android.R.id.tabs), 1)).perform(click());

	// Select page 1 in ViewPager with id R.id.view_pager
onView(withId(R.id.view_pager)).perform(selectViewPagerPage(1));

	// Click at ImageButton with child index 1 of parent with id R.id.action_bar
onView(nthChildOf(withId(R.id.action_bar), 1)).perform(click());

	// Click at item with value 'com.example.prabaths.models.NavItem@421717c8' in ListView
	// see details at http://droidtestlab.com/adapterView.html
        onData(anything()) // We are using the position so don't need to specify a data matcher
                .inAdapterView(withId(R.id.nav_list)) // Specify the explicit id of the ListView
                .atPosition(0) // Explicitly specify the adapter item to use
                .perform(click());

        // Click at ImageButton with child index 1 of parent with id R.id.action_bar
onView(nthChildOf(withId(R.id.action_bar), 1)).perform(click());

	// Click at item with value 'com.example.prabaths.models.SectionItem@42171d28' in ListView
	// see details at http://droidtestlab.com/adapterView.html
        onData(anything()) // We are using the position so don't need to specify a data matcher
                .inAdapterView(withId(R.id.nav_list)) // Specify the explicit id of the ListView
                .atPosition(1) // Explicitly specify the adapter item to use
                .perform(click());

        // Click at AppCompatButton with id android.R.id.button3
onView(withId(android.R.id.button3)).perform(click());

	// Click at AppCompatButton with id android.R.id.button3
onView(withId(android.R.id.button3)).perform(click());

	// Click at LinearLayout with child index 1 of parent with id android.R.id.tabs
onView(nthChildOf(withId(android.R.id.tabs), 1)).perform(click());

	// Select page 1 in ViewPager with id R.id.view_pager
onView(withId(R.id.view_pager)).perform(selectViewPagerPage(1));

	// Click at ImageButton with child index 1 of parent with id R.id.action_bar
onView(nthChildOf(withId(R.id.action_bar), 1)).perform(click());

	// Click at item with value 'com.example.prabaths.models.NavItem@42171ec0' in ListView
	// see details at http://droidtestlab.com/adapterView.html
        onData(anything()) // We are using the position so don't need to specify a data matcher
                .inAdapterView(withId(R.id.nav_list)) // Specify the explicit id of the ListView
                .atPosition(2) // Explicitly specify the adapter item to use
                .perform(click());

        // Click at AppCompatButton with id android.R.id.button3
onView(withId(android.R.id.button3)).perform(click());

	// Click at ImageButton with child index 1 of parent with id R.id.action_bar
onView(nthChildOf(withId(R.id.action_bar), 1)).perform(click());

	// Click at item with value 'com.example.prabaths.models.NavItem@42171f30' in ListView
	// see details at http://droidtestlab.com/adapterView.html
        onData(anything()) // We are using the position so don't need to specify a data matcher
                .inAdapterView(withId(R.id.nav_list)) // Specify the explicit id of the ListView
                .atPosition(3) // Explicitly specify the adapter item to use
                .perform(click());

        // Click at AppCompatButton with id android.R.id.button3
onView(withId(android.R.id.button3)).perform(click());

	// Click at ImageButton with child index 1 of parent with id R.id.action_bar
onView(nthChildOf(withId(R.id.action_bar), 1)).perform(click());

	// Swipe up at ListView with id R.id.nav_list
onView(withId(R.id.nav_list)).perform(swipeUp());

	// Click at item with value 'com.example.prabaths.models.SectionItem@42171f98' in ListView
	// see details at http://droidtestlab.com/adapterView.html
        onData(anything()) // We are using the position so don't need to specify a data matcher
                .inAdapterView(withId(R.id.nav_list)) // Specify the explicit id of the ListView
                .atPosition(4) // Explicitly specify the adapter item to use
                .perform(click());

        // Click at LinearLayout with child index 1 of parent with id android.R.id.tabs
onView(nthChildOf(withId(android.R.id.tabs), 1)).perform(click());

	// Select page 1 in ViewPager with id R.id.view_pager
onView(withId(R.id.view_pager)).perform(selectViewPagerPage(1));

	// Click at LinearLayout with child index 2 of parent with id android.R.id.tabs
onView(nthChildOf(withId(android.R.id.tabs), 2)).perform(click());

	// Select page 2 in ViewPager with id R.id.view_pager
onView(withId(R.id.view_pager)).perform(selectViewPagerPage(2));

	// Click at ImageButton with child index 1 of parent with id R.id.action_bar
onView(nthChildOf(withId(R.id.action_bar), 1)).perform(click());

	// Click at item with value 'com.example.prabaths.models.NavItem@42172008' in ListView
	// see details at http://droidtestlab.com/adapterView.html
        onData(anything()) // We are using the position so don't need to specify a data matcher
                .inAdapterView(withId(R.id.nav_list)) // Specify the explicit id of the ListView
                .atPosition(5) // Explicitly specify the adapter item to use
                .perform(click());

        // Click at ImageButton with child index 1 of parent with id R.id.action_bar
onView(nthChildOf(withId(R.id.action_bar), 1)).perform(click());

	// Click at item with value 'com.example.prabaths.models.NavItem@42172080' in ListView
	// see details at http://droidtestlab.com/adapterView.html
        onData(anything()) // We are using the position so don't need to specify a data matcher
                .inAdapterView(withId(R.id.nav_list)) // Specify the explicit id of the ListView
                .atPosition(6) // Explicitly specify the adapter item to use
                .perform(click());

        // Swipe down at ScrollView with id R.id.scrollView3
onView(withId(R.id.scrollView3)).perform(swipeDown());

	// Click at ImageButton with child index 1 of parent with id R.id.action_bar
onView(nthChildOf(withId(R.id.action_bar), 1)).perform(click());

	// Click at item with value 'com.example.prabaths.models.NavItem@421720f8' in ListView
	// see details at http://droidtestlab.com/adapterView.html
        onData(anything()) // We are using the position so don't need to specify a data matcher
                .inAdapterView(withId(R.id.nav_list)) // Specify the explicit id of the ListView
                .atPosition(7) // Explicitly specify the adapter item to use
                .perform(click());

        // Click at ImageButton with child index 1 of parent with id R.id.action_bar
onView(nthChildOf(withId(R.id.action_bar), 1)).perform(click());

	// Swipe up at ListView with id R.id.nav_list
onView(withId(R.id.nav_list)).perform(swipeUp());

	// Click at item with value 'com.example.prabaths.models.SectionItem@42172318' in ListView
	// see details at http://droidtestlab.com/adapterView.html
        onData(anything()) // We are using the position so don't need to specify a data matcher
                .inAdapterView(withId(R.id.nav_list)) // Specify the explicit id of the ListView
                .atPosition(12) // Explicitly specify the adapter item to use
                .perform(click());

        // Click at LinearLayout with child index 1 of parent with id android.R.id.tabs
onView(nthChildOf(withId(android.R.id.tabs), 1)).perform(click());

	// Select page 1 in ViewPager with id R.id.view_pager
onView(withId(R.id.view_pager)).perform(selectViewPagerPage(1));

	// Click at ImageButton with child index 1 of parent with id R.id.action_bar
onView(nthChildOf(withId(R.id.action_bar), 1)).perform(click());

	// Click at item with value 'com.example.prabaths.models.NavItem@421723f0' in ListView
	// see details at http://droidtestlab.com/adapterView.html
        onData(anything()) // We are using the position so don't need to specify a data matcher
                .inAdapterView(withId(R.id.nav_list)) // Specify the explicit id of the ListView
                .atPosition(13) // Explicitly specify the adapter item to use
                .perform(click());
        // Click at LinearLayout with child index 1 of parent with id android.R.id.tabs
onView(nthChildOf(withId(android.R.id.tabs), 1)).perform(click());

	// Select page 1 in ViewPager with id R.id.view_pager
onView(withId(R.id.view_pager)).perform(selectViewPagerPage(1));

	// Click at ImageButton with child index 1 of parent with id R.id.action_bar
onView(nthChildOf(withId(R.id.action_bar), 1)).perform(click());

	// Swipe up at ListView with id R.id.nav_list
onView(withId(R.id.nav_list)).perform(swipeUp());

	// Click at item with value 'com.example.prabaths.models.NavItem@42172450' in ListView
	// see details at http://droidtestlab.com/adapterView.html
        onData(anything()) // We are using the position so don't need to specify a data matcher
                .inAdapterView(withId(R.id.nav_list)) // Specify the explicit id of the ListView
                .atPosition(14) // Explicitly specify the adapter item to use
                .perform(click());

        // Click at LinearLayout with child index 1 of parent with id android.R.id.tabs
onView(nthChildOf(withId(android.R.id.tabs), 1)).perform(click());

	// Select page 1 in ViewPager with id R.id.view_pager
onView(withId(R.id.view_pager)).perform(selectViewPagerPage(1));

	// Click at LinearLayout with child index 2 of parent with id android.R.id.tabs
onView(nthChildOf(withId(android.R.id.tabs), 2)).perform(click());

	// Select page 2 in ViewPager with id R.id.view_pager
onView(withId(R.id.view_pager)).perform(selectViewPagerPage(2));

	// Select page 1 in ViewPager with id R.id.view_pager
onView(withId(R.id.view_pager)).perform(selectViewPagerPage(1));

	// Select page 0 in ViewPager with id R.id.view_pager
onView(withId(R.id.view_pager)).perform(selectViewPagerPage(0));

	// Click at ImageButton with child index 1 of parent with id R.id.action_bar
onView(nthChildOf(withId(R.id.action_bar), 1)).perform(click());

	// Swipe down at ListView with id R.id.nav_list

    }

    

    public static Matcher<View> nthChildOf(final Matcher<View> parentMatcher, final int childPosition) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
            }
            @Override
            public boolean matchesSafely(View view) {
                if (!(view.getParent() instanceof ViewGroup)) {
                    return false;
                }
                ViewGroup group = (ViewGroup) view.getParent();
                return parentMatcher.matches(group) && view.equals(group.getChildAt(childPosition));
            }
        };
    }


    public static ViewAction selectViewPagerPage(final int pos) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(android.support.v4.view.ViewPager.class);
            }
            @Override
            public String getDescription() {
                return "select page in ViewPager";
            }
            @Override
            public void perform(UiController uiController, View view) {
                ((android.support.v4.view.ViewPager)view).setCurrentItem(pos);
            }
        };
    }

}