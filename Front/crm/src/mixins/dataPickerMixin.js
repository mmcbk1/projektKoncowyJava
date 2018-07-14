import moment from 'moment';
import Datepicker from 'vuejs-datepicker';

export const dataPickerMixin = {
    components: {
        'date-picker': Datepicker,
    },
    data() {
        return {

        }
    },
    methods: {
        customFormatter(date) {
            let dataObj = new Date(date);
            return moment(dataObj).format('YYYY-MM-DD');
        }
    }
};