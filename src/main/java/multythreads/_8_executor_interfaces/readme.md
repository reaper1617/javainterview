### Executor:

- one method : execute(Runnable r)

### ExecutorService extends Executor:

can return Future object representing results

- submit(Runnable)
- submit(Callable)
- submit(Runnable r, T result)

### ScheduledExecutorService extends ExecutorService
add methods for scheduled execution

- scheduleAtFixedRate
- scheduleAtFixedDelay