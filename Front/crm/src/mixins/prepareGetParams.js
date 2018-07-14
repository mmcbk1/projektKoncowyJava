export const prepareGetParams = {
    data() {
        return {}
    },
    methods: {
        addToUrlGet(url, name, value) {
            if(!value){
                return '';
            }
            let pattern = '[\?]';
            let prefix = '';
            prefix = url.match(pattern)
                ? '&'
                : '?';
            
           return prefix + name + '=' + encodeURI(value);
        },
    }
};