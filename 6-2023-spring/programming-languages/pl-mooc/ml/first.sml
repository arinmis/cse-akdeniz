(* tuple has custom number of elements *)

fun sum (pr : int*int) =
  (#1 pr + #2 pr) 

val pair = (1, 2)

val result = sum(pair)


(* (#1 pair) *)


(* 
 *
 * list can have any number of elements 
 * all the list elements list must have same type
 * no type check for the list elements
 *
 * *) 
