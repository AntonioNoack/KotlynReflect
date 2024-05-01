# Kotlyn Reflection

## Project Overview
Minimal Kotlin reflections on JVM for [Rem's Engine](https://github.com/AntonioNoack/RemsEngine):
Since Kotlin forbids the usage of the kotlin namespace in foreign projects,
I decided to rename "kotlin" to "kotlyn", and have a script when exporting that
replaces any references in [Rem's Engine](https://github.com/AntonioNoack/RemsEngine) in a few packages like
"kotlin.reflect" with "kotlyn.reflect".

## Motivation
Kotlin's own reflection library is very bloated, using 3MB of compressed zip-space.
I want(ed) to still use Kotlin's reflection, so I maybe can use Kotlin/JS or Kotlin/WASM as a target for my game engine.
But space is costly on the web, so I want(ed) to optimize it.

The total size of this library is 14kB (~200x smaller).