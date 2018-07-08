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

            if(urlExplode.length > 1 && urlExplode[1]){
                param += '&';
            }

            if (obj[name]) {
                this.url += param + name + '=' + obj[name];
            }

        },
        resetUrl(){
            this.url = '?';
        }
    }
};