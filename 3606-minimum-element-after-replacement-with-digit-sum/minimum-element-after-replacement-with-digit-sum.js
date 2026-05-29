const minElement = A => A.reduce((a, c) =>
    Math.min(a, c - 9 * (((c / 10) | 0) + ((c / 100) | 0) + ((c / 1000) | 0) + ((c / 10000) | 0))),
    36);