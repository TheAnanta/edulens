import Sidebar from "@/components/Sidebar";
import FAQ from "./FAQ";

export default function Page() {
  return (
    <div className="flex">
      <Sidebar />
      <div className="pt-24 px-16 w-full flex justify-between items-start space-x-4">
        <div className="flex flex-col justify-between items-center space-y-4">
          <div className="flex justify-between items-center space-x-4">
            <FAQ />
            <FAQ />
          </div>
          <div className="p-8 bg-[var(--secondary-color)] rounded-2xl">
            <h1 className="font-bold text-xl mb-4">FAQs</h1>
            <ol className="">
              <li className="mb-4">
                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Voluptatibus illo corrupti quos id suscipit ea explicabo, omnis
                dolores obcaecati veniam possimus magnam et a inventore
                architecto dolorem nemo unde fugiat.
              </li>
              <li className="mb-4">
                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Voluptatibus illo corrupti quos id suscipit ea explicabo, omnis
                dolores obcaecati veniam possimus magnam et a inventore
                architecto dolorem nemo unde fugiat.
              </li>
              <li className="mb-4">
                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Voluptatibus illo corrupti quos id suscipit ea explicabo, omnis
                dolores obcaecati veniam possimus magnam et a inventore
                architecto dolorem nemo unde fugiat.
              </li>
            </ol>
          </div>
        </div>
      </div>
    </div>
  );
}
