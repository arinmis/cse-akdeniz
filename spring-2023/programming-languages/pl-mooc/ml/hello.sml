(* works for positive x'es, x >= 0 *)
fun pow(x: int, y : int) = 
  if y = 0
  then 1
  else x * pow(x, y - 1)

fun cube(x: int) = 
  pow(x, 3)

val value = cube(4)
(* val value1 = cube(2, cube(3)) *)
