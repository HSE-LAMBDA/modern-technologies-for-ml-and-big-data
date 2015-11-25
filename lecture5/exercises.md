# Exercises

- calculate pi by integrating area of circle: `integrate sqrt(1.0 - x * x)`
- distributed matrix multiplication: `dot(m1: RDD[Array[Double]], m2: RDD[Array[Double]]) = m1 x m2.T`
let shape of the matricies be `N x M` and `K x M` with large N and K and small M. 
- distributed gradient descent `dgd(loss: Array[Double] => RDD[Double], dloss: Array[Double] => RDD[Array[Double]])` where loss function is sum of errors.
