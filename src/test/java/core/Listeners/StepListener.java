package core.Listeners;

import io.qameta.allure.model.StepResult;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StepListener implements LifecycleListener {

    @Override
    @SneakyThrows
    public void beforeStepStop(final StepResult result) {

    }
}
