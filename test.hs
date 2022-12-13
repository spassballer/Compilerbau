-- data Folge a = Empty
--     | Cons(a,Folge a)
--         deriving(Show)

-- hd ::Folge a -> a
-- hd (Cons(e,f)) = e

-- tl ::Folge a -> Folge a
-- tl (Cons(e,f)) = f

myand ::(Bool,Bool) -> Bool
myand(True,True) = True
myand(_,_) = False

myor ::(Bool,Bool) -> Bool
myor(False,False) = False
myor(_,_) = True

myxor ::(Bool,Bool) -> Bool
myxor(True,False) = True
myxor(False,True) = True
myxor(_,_) = False

square ::Int -> Int
square(x) = x^2