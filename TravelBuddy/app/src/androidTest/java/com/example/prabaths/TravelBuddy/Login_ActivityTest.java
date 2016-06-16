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
public class Login_ActivityTest {

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule<>(Login_Activity.class);

    @Test
    public void testGenerated() {

        // Swipe up at ScrollView with child index 0 of parent with id R.id.login_content
        onView(nthChildOf(withId(R.id.login_content), 0)).perform(swipeUp());

        // Click at AppCompatButton with id R.id.signUpBtn
        onView(withId(R.id.signUpBtn)).perform(scrollTo());
        onView(withId(R.id.signUpBtn)).perform(click());

        // Swipe up at ScrollView with child index 0 of parent with id R.id.prof
        onView(nthChildOf(withId(R.id.prof), 0)).perform(swipeUp());

        // Click at AppCompatButton with id R.id.cancelBtn
        onView(withId(R.id.cancelBtn)).perform(scrollTo());
        onView(withId(R.id.cancelBtn)).perform(click());

        // Click at AppCompatButton with id R.id.loginBtn
        onView(withId(R.id.loginBtn)).perform(scrollTo());


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

}