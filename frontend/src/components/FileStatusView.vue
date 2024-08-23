<template>

    <v-data-table
        :headers="headers"
        :items="fileStatus"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'FileStatusView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "size", value: "size" },
                { text: "fileName", value: "fileName" },
                { text: "isIndexed", value: "isIndexed" },
                { text: "isUpload", value: "isUpload" },
                { text: "videoUrl", value: "videoUrl" },
                { text: "fileId", value: "fileId" },
            ],
            fileStatus : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/fileStatuses'))

            temp.data._embedded.fileStatuses.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.fileStatus = temp.data._embedded.fileStatuses;
        },
        methods: {
        }
    }
</script>

