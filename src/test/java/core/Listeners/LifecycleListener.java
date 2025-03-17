package core.Listeners;

import io.qameta.allure.model.StepResult;

public interface LifecycleListener {

    default void beforeStepStart(final StepResult result) {
    }

    default void afterStepStart(final StepResult result) {
    }

    default void beforeStepStop(final StepResult result) {
    }

    default void afterStepStop(final StepResult result) {
    }
}
