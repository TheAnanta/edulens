import Sidebar from "@/components/Sidebar";
import AvatarImage from "@/components/AvatarImage";
import CourseCard from "./CourseCard";
import Footer from "@/components/Footer";

export default function Page() {
  return (
    <div className="flex relative">
      <Sidebar />
      <div className="pt-36 px-24 w-full my-6">
        <div className="flex space-x-4">
          <div className="text-2xl font-normal">My Courses</div>
        </div>
        <div className="grid grid-cols-3 mt-10 gap-8 w-full">
          <CourseCard
            attribute="CSEN0001"
            title="Software Engineering"
            key="bi"
          />
          <CourseCard
            attribute="CSEN0001"
            title="Software Engineering"
            key="bi"
          />
          <CourseCard
            attribute="CSEN0001"
            title="Software Engineering"
            key="bi"
          />
          <CourseCard
            attribute="CSEN0001"
            title="Software Engineering"
            key="bi"
          />
          <CourseCard
            attribute="CSEN0001"
            title="Software Engineering"
            key="bi"
          />
          <CourseCard
            attribute="CSEN0001"
            title="Software Engineering"
            key="bi"
          />
          <CourseCard
            attribute="CSEN0001"
            title="Software Engineering"
            key="bi"
          />
          <CourseCard
            attribute="CSEN0001"
            title="Software Engineering"
            key="bi"
          />
          <CourseCard
            attribute="CSEN0001"
            title="Software Engineering"
            key="bi"
          />
          <CourseCard
            attribute="CSEN0001"
            title="Software Engineering"
            key="bi"
          />
        </div>
      </div>
    </div>
  );
}
