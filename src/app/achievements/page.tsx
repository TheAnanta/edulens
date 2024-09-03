import Sidebar from "@/components/Sidebar";
import AvatarImage from "@/components/AvatarImage";
import AchievementCard from "./AchievementCard";
import RatingNews from "./RatingNews";
import Footer from "@/components/Footer";

export default function Page(props: { params: { id: string } }) {
  return (
    <div className="flex relative">
      <Sidebar />
      <div className="pt-24 px-16 w-full my-6">
        <div className="flex space-x-4">
          <div className="text-3xl font-semibold">
            Achievements
            <span className="font-semibold text-3xl uppercase">
              {props.params.id}
            </span>
          </div>
          <AvatarImage />
        </div>
        <div className="grid grid-cols-3 mt-12 gap-8 w-full">
          <AchievementCard />
          <AchievementCard />
          <AchievementCard />
          <AchievementCard />
          <AchievementCard />
          <AchievementCard />
        </div>
        <h2 className="font-semibold my-12 text-3xl">
          Ratings and Latest News
        </h2>
        <div className="flex justify-between my-8 gap-6 ">
          <RatingNews />
          <RatingNews />
        </div>
      </div>
    </div>
  );
}
