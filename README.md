= specs2 concurrency boom boom

specs2, in versions 3.8.7 and up, introduces some changes in how it
concurrently runs specs. These specs seem to expose some issues with how sbt
sets up the thread's current context classloader for subprojects. This project
attempts to present a minimal test case that shows these issues.

The simplest example:

```
$ sbt
sbt> project1/test
// should work
sbt> project2/test
// *may* fail
sbt> all project1/test project2/test
// will fail
```

The classes `DoTheBoom` and `DoTheBoom2` both attempt to load a class in the
thread's current context classloader. Each one attempts to load a class from
its respective project. Running them together shows that sbt will run both
projects with the same thread context classloader, leading to failure to load
the specified class in one of the classloaders.

Additionally, running them individually will sometimes (possibly reproducibly)
run one project with the other's classloader as the thread context classloader.

There seems to be no issue before specs2 3.8.7, but there also seems to be
nothing classloader-related in the specs2 3.8.7 release. You can confirm this
by bumping the specs2 version down to 3.8.6 and running:

```
sbt> all project1/test project2/test
```

This should pass.
