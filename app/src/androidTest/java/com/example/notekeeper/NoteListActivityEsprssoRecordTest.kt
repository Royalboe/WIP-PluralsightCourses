package com.example.notekeeper


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class NoteListActivityEspressoRecordTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(NoteListActivity::class.java)

    @Test
    fun noteListActivityEsprssoRecordTest() {
        val materialTextView = onData(anything())
            .inAdapterView(
                allOf(
                    withId(R.id.listNotes),
                    childAtPosition(
                        withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                        0
                    )
                )
            )
            .atPosition(0)
        materialTextView.perform(click())

        val actionMenuItemView = onView(
            allOf(
                withId(R.id.action_next), withContentDescription("Next"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        actionMenuItemView.perform(click())

        val actionMenuItemView2 = onView(
            allOf(
                withId(R.id.action_next), withContentDescription("Next"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        actionMenuItemView2.perform(click())

        val actionMenuItemView3 = onView(
            allOf(
                withId(R.id.action_next), withContentDescription("Next"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        actionMenuItemView3.perform(click())

        val actionMenuItemView4 = onView(
            allOf(
                withId(R.id.action_next), withContentDescription("Next"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        actionMenuItemView4.perform(click())

        val actionMenuItemView5 = onView(
            allOf(
                withId(R.id.action_next), withContentDescription("Next"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        actionMenuItemView5.perform(click())

        val actionMenuItemView6 = onView(
            allOf(
                withId(R.id.action_next), withContentDescription("Next"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        actionMenuItemView6.perform(click())

        val actionMenuItemView7 = onView(
            allOf(
                withId(R.id.action_next), withContentDescription("Next"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        actionMenuItemView7.perform(click())

        val actionMenuItemView8 = onView(
            allOf(
                withId(R.id.action_next), withContentDescription("Next"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        actionMenuItemView8.perform(click())

        val actionMenuItemView9 = onView(
            allOf(
                withId(R.id.action_previous), withContentDescription("Previous"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        actionMenuItemView9.perform(click())

        val actionMenuItemView10 = onView(
            allOf(
                withId(R.id.action_previous), withContentDescription("Previous"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        actionMenuItemView10.perform(click())

        val actionMenuItemView11 = onView(
            allOf(
                withId(R.id.action_previous), withContentDescription("Previous"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        actionMenuItemView11.perform(click())

        val actionMenuItemView12 = onView(
            allOf(
                withId(R.id.action_previous), withContentDescription("Previous"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        actionMenuItemView12.perform(click())

        val actionMenuItemView13 = onView(
            allOf(
                withId(R.id.action_previous), withContentDescription("Previous"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        actionMenuItemView13.perform(click())

        val actionMenuItemView14 = onView(
            allOf(
                withId(R.id.action_previous), withContentDescription("Previous"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        actionMenuItemView14.perform(click())

        val actionMenuItemView15 = onView(
            allOf(
                withId(R.id.action_previous), withContentDescription("Previous"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        actionMenuItemView15.perform(click())

        val actionMenuItemView16 = onView(
            allOf(
                withId(R.id.action_previous), withContentDescription("Previous"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.toolbar),
                        1
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        actionMenuItemView16.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
