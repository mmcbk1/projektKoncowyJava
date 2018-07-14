export const filters = {
    filters: {
        setEmptyChar(val) {
            if (val) {
                return val;
            }
            return '-';
        }
    },
}