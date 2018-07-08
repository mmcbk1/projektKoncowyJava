export const prepareGetParams = {
    data(){
        return {
            url: '?',
        }
    },
    methods:{
        prepareUrl(name, obj) {
            let param = '';
            let urlExplode = this.url.split('?');

            if(urlExplode.length > 1){
                param += '&';
            }

            if (this[obj][name]) {
                return param += name + '=' + this[obj][name];
            }

            return '';
        },
        resetUrl(){
            this.url = '?';
        }
    }
};