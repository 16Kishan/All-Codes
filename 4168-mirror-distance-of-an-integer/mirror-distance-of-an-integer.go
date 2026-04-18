func mirrorDistance(n int) int {
    rev := 0
    temp := n

    for temp > 0 {
        digit := temp % 10
        rev = rev*10 + digit
        temp /= 10
    }

    if n > rev {
        return n - rev
    }
    return rev - n
}