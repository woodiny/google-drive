<template>

    <v-card outlined>
        <v-card-title>
            FileStatus # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="Size" v-model="item.size" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="FileName" v-model="item.fileName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="IsIndexed" v-model="item.isIndexed" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="IsUpload" v-model="item.isUpload" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="VideoUrl" v-model="item.videoUrl" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="FileId" v-model="item.fileId" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'FileStatusViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/fileStatuses/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

