<template>
    <div class="pagination-container">
      <el-pagination
        :current-page.sync="currentPage"
        :page-size="pageSize"
        :layout="layout"
        :total="total"
        @current-change="handleCurrentChange"
      />
    </div>
  </template>
  <!-- :page-size.sync="pageSize" -->
  <script>
  export default {
    name: "Pagination",
    props: {
      total: {
        required: true,
      },
      page: {
        type: Number,
        default: 1,
      },
      layout: {
        type: String,
        default: "total, sizes, prev, pager, next, jumper",
      },
      pageSize: {
        type: Number,
        default: 1,
      },
    },
    computed: {
      currentPage: {
        get() {
          return this.page;
        },
        set(val) {
          this.$emit("update:page", val);
        },
      },

    },
    methods: {
      handleCurrentChange(val) {
        this.$emit("currentChange", { page: val, limit: this.pageSize });
      },
    },
  };
  </script>