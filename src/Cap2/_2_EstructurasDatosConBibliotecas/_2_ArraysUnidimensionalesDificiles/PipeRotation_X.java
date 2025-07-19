package Cap2._2_EstructurasDatosConBibliotecas._2_ArraysUnidimensionalesDificiles;

public class PipeRotation_X {


/*  PHYTON CODE
class State(int):
    NONE = 0
    DOWN = 1
    RIGHT = 2

    @staticmethod
    def none():
        return State(State.NONE)

    @staticmethod
    def down():
        return State(State.DOWN)

    @staticmethod
    def right():
        return State(State.RIGHT)

    @staticmethod
    def down_and_right():
        return State(State.RIGHT | State.DOWN)

    def __new__(cls, x):
        return int.__new__(cls, x)

    def r(self):
        return self & State.RIGHT != 0

    def d(self):
        return self & State.DOWN != 0

def check_square(r, d, x):
    if x == 'A':
        if r or d:
            return False, State.none()
        else:
            return True, State.none()
    elif x == 'B':
        if r and not d:
            return True, State.right()
        elif d and not r:
            return True, State.down()
        else:
            return False, State.none()
    elif x == 'C':
        if r and d:
            return True, State.none()
        elif r:
            return True, State.down()
        elif d:
            return True, State.right()
        else:
            return True, State.down_and_right()
    else:
        if r and d:
            return True, State.down_and_right()
        else:
            return False, State.none()

def pipe_check_row(row,states):
    for c,x in enumerate(row):
        r, d = c != 0 and states[c-1].r(), states[c].d()
        valid, state = check_square(r,d,x)
        if not valid:
            return False
        states[c] = state
    return not states[-1].r()

def pipe_check(c,mat):
    states = [State.none() for _ in range(c)]
    for row in mat:
        if not pipe_check_row(row,states):
            return False
    return all(not s.d() for s in states)

def main():
    r,c = map(int,input().split())
    mat = [input() for _ in range(r)]
    print('Possible' if pipe_check(c,mat) else 'Impossible')

if __name__ == "__main__":
    main()
 */




/* HASKELL CODE

-- Kattis - piperotation
-- Relatively straightforward passing through the matrix in row major order (tho column major order would work)
-- We keep track of whether we need to connect each cell to the cell above it or to the cell to the left of it
-- At the end of each row, we need to ensure we don't need to connect the last cell to the cell to the right of it
-- At the end of checking all rows, we need to ensure we don't need to connect any bottom cells to the cell below it
-- Make use of the Maybe data type to deal with the "stopping early" cases
-- Time: O(hw)
main :: IO()
main = interact (solve . tail . lines)

solve :: [String] -> String
solve xs = check (foldl attach (Just (repeat False)) xs)

attach :: Maybe [Bool] -> String -> Maybe [Bool]
attach Nothing _ = Nothing
attach (Just prev) row = attachPipe (prev, False) row []

attachPipe :: ([Bool], Bool) -> String -> [Bool] -> Maybe [Bool]
attachPipe (_, connectLeft) [] curRow = if connectLeft then Nothing else Just (reverse curRow)
attachPipe (p:ps, connectLeft) (x:xs) curRow
    | x == 'A' = if (connectLeft || p) then Nothing else attachPipe (ps, False) xs (False:curRow)
    | x == 'B' = case p of
        True -> if connectLeft then Nothing else attachPipe (ps, False) xs (True:curRow)
        False -> if connectLeft then attachPipe (ps, True) xs (False:curRow) else Nothing
    | x == 'C' = case p of
        True -> if connectLeft then attachPipe (ps, False) xs (False:curRow) else attachPipe (ps, True) xs (False:curRow)
        False -> if connectLeft then attachPipe (ps, False) xs (True:curRow) else attachPipe (ps, True) xs (True:curRow)
    | x == 'D' = case p of
        True -> if connectLeft then attachPipe (ps, True) xs (True:curRow) else Nothing
        False -> Nothing
attachPipe _ _ _ = error "Invalid input"

check :: Maybe [Bool] -> String
check Nothing = "Impossible"
check (Just xs) = if all (==False) xs then "Possible" else "Impossible"
 */
}