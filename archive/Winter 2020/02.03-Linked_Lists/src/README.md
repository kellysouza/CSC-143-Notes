# Linked Lists and the List Interface

## Previously, on CSC 143

Primitive arrays in Java and fixed length, `int[] array = new int[n];`, for good reasons:
 
  - By definition, arrays are contiguously stored.

  - Indexing beyond the space dedicated to the array is *dangerous* as it can overwrite other objects on the **heap**.

  - The allocation (`new`) and freeing of Objects (garbage collection) on the heap causes **fragmentation**, the interleaving of free and occupied heap space.

  - **Fragmentation** limits the availability of large, *contiguous* chunks of free memory.

As developers, fixed length arrays are a significant limitation.

  - We don't always know in advance how much space we need.
  - Allocating an array that's too small can cause us can run out of space when we need it.
  - Allocating an array that's too large can be wasteful.

### Big O

We use **Big O** to measure the runtime and memory cost of algorithms.

Big O can be determined with three steps:

 1. Start with some input size of length `n`
 2. Count the number of steps relative to `n`
 3. Drop constants and constant multipliers

Common "classes" of Big O are `O(1)` (constant time), `O(logn)` (logarithmic), `O(n)` (linear), `O(nlogn)` (linearithmic), `O(n^2)` (quadratic).

The smaller the Big O, the more efficient the algorithm.

## Linked Lists

### Pointers and References Recap

**Memory addresses** are locations in memory, much like street addresses.

Every Object in memory has a dedicated memory address, describing its physical location in memory.

**Pointers** are plain integers that store memory addresses.

A **reference** is a special kind of pointer that has a *type* and does not permit pointer arithmetic.

In Java, every Object variable is actually a **reference** to the Object. Java is *pass by value*, meaning arguments and return values are copied as references.

See: ReferenceTest.java

### Linked Lists: Motivation

Arrays and ArrayLists are *contiguous* by definition, but this has its own consequences:

  - Contiguous region must exist in the heap to store array
  - Insertion at middle is costly, must copy all successive elements forward `O(n)`
  - Insertion at front is costly, must copy all successive elements forward `O(n)`
  - Deletion at front/middle is costly, must copy all successive elements backward `O(n)`
  
See (Debug): ArrayListTest.java

### Linked Lists: Description

The **Linked List** is a kind of data structure where each element stores a value (sometimes called payload) and a *reference* to the next value.

Rather than store data contiguously, store each element separately. Then, *link* them together with pointers (references), in a given order.

By chaining several values together using references, a Linked List is formed.

Whiteboard: Singly Linked List

See: Node.java, NodeTest.java

Let's analyze the runtime cost of Linked List operations.

  - Indexing: `O(n)`
  - Iteration: `O(n)`

  - Insert Front: `O(1)`
  - Insert Back: `O(n)`, with tail pointer, `O(1)`
  - Insert Middle: `O(n)`, during iteration, `O(1)`

  - Remove Front: `O(1)`
  - Remove Back: `O(n)`, with tail pointer, `O(1)`
  - Remove Middle: `O(n)`, during iteration, `O(1)`

## Interfaces and Runtime

Java interfaces like Collection, and the classes the implement them like Array List,
*abstract* away the complexities of underlying implementation.

The simple `Node` structure acts as an internal container that manages the value and next item.

Using it directly, however, is inconvenient and complex:

  - Indexing and iteration requires looping over `Node` references
  - Failing to preserve the head `Node` can accidentally cause other nodes to be lost
  - Tracking list length requires counting every insertion and removal
  - Middle insertion and removal can be hard to get right

Let's write a wrapper class that manages the Node Object for us,
revealing a simpler interface for the Linked List.

See: LinkedList.java
